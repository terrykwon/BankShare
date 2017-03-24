import os
import pymysql
import hashlib
from flask import Flask, request, session, url_for, redirect, \
    render_template, abort, g, flash
from werkzeug.security import check_password_hash, generate_password_hash

BASE_DIR   =  os.path.abspath('.')
TARGET_DIR =  os.path.join(BASE_DIR, "DB")
TARGET_FILE = 'BankShare.db'
TARGET_FILE_FULL_PATH = os.path.join(TARGET_DIR, TARGET_FILE)


# create application :)
app = Flask(__name__)
app.config.from_object(__name__)
app.secret_key = 'adEN#V)(#_!NVNLASDF32rasdf'

def connect_db():
    return pymysql.connect(host='localhost',user='bankShare',
                           password='bankShare777', db='bankshare', charset='utf8')

@app.before_request
def before_request():
    g.db = connect_db()
    g.user = None
    if 'email' in session:
        curs = g.db.cursor();
        curs.execute('''select * from user where email = %s''',
                 (session['email']))
        rows = curs.fetchall()
        g.user = rows[0][1]
        print(g.user)

@app.teardown_request
def teardown_request(exception):
    if hasattr(g, 'db'):
        g.db.close()

@app.route('/')
def front():
    if g.user :
        return redirect(url_for('main'))
    return render_template('front.html')

@app.route('/signup', methods=['GET', 'POST'])
def signup():
    if request.method == 'POST':
        try:
            print(request.form['username'],request.form['email'],request.form['phone'],request.form['password'])
            g.db.cursor().execute('''insert into user(username, email, phone, password) values(%s,%s,%s,%s)''',
                              (request.form['username'], request.form['email'],request.form['phone'],
                               request.form['password']))
            g.db.commit();
        except:
            pass
        finally:
            return redirect(url_for('front'))
    return render_template('signup.html')

@app.route('/login', methods=['POST'])
def login():
    # username, email ,phone, password
    if request.method == 'POST':

        curs = g.db.cursor();
        curs.execute('''select * from user where email = %s and password = %s''',
                 (request.form['email'],request.form['password']))
        rows = curs.fetchall()
        print('rows',len(rows))
        if len(rows) == 0:
            pass
        else:
            session['email'] = rows[0][1];
            session['name'] = rows[0][0];
            return redirect(url_for('main'))

    return render_template('front.html')

@app.route('/logout')
def logout():
    session.clear()
    return redirect(url_for('front'))

@app.route('/main', methods=['GET'])
def main():
    if not g.user:
        return redirect(url_for('front'))
    colors = ['#4092cf','#3272a1','#407b4e','#325f3c','#6a3072','#54265b']
    curs = g.db.cursor();
    curs.execute('''select * from room''')
    rows = curs.fetchall()
    print(rows)
    return render_template('main.html',rooms = rows, colors = colors)

@app.route('/makeroom', methods=['GET','POST'])
def makeroom():
    if request.method == 'POST':
        g.db.cursor().execute('''insert into room(roomname, roominfo, name, birth, bank, account) values(%s,%s,%s,%s,%s,%s)''',
                (request.form['roomname'], request.form['roominfo'],request.form['name'],request.form['birth'],
                 request.form['bank'],request.form['account']))
        print()
        lastid = g.db.insert_id()
        print("****LASTID*****:",g.db.insert_id())
        print()
        g.db.cursor().execute('''insert into total(id, money) values(%s,%s) ''',(lastid,0))
        g.db.cursor().execute('''insert into member(id, name) values(%s,%s)''',(lastid, session['name']))
        g.db.commit();
        return redirect(url_for('main'))
        
    return render_template('makeroom.html')

@app.route('/room/<id>')
def room(id):
    curs = g.db.cursor()
    curs.execute('''select * from room where id = %s''',(id))
    room = curs.fetchall()
    curs.execute('''select * from trans where id = %s order by date desc''',(id))
    trans = curs.fetchall()

    curs.execute('''select * from member where id = %s''',(id))
    member = curs.fetchall()
    curs.execute('''select * from total where id = %s''',(id))
    total = curs.fetchall()
    total = total[0][1]
    total = "{:,}".format(total)
    print('member',member)
    return render_template('room.html',room = room[0], trans = trans, member = member, total = total, rid=id)

@app.route('/room/add/<id>', methods=['GET','POST'])
def addMember(id):
    curs = g.db.cursor()
    if request.method == 'POST':
        print("******checkuser**********")
        users = request.form.getlist('checkuser')
        for user in users:
            curs.execute('''insert into member values(%s,%s)''',(id,user))
        g.db.commit();
        return redirect(url_for('room',id=id))

    curs.execute('''select * from user''')
    users = curs.fetchall()
    print(users)
    return render_template('addMember.html',rid=id,users=users)

if __name__ == '__main__':
    app.run(host='0.0.0.0',port=int('7000'))
