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
                           password='bankShare777', db='bankshare')

@app.before_request
def before_request():
    g.db = connect_db()
    g.user = None
    if 'user_id' in session:
        g.user = query_db('select * from user where email = ?', session['email'], one=True)

@app.teardown_request
def teardown_request(exception):
    if hasattr(g, 'db'):
        g.db.close()

@app.route('/')
def front():
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
            return redirect(url_for('main'))

    return render_template('front.html')

@app.route('/main', methods=['GET'])
def main():
    return render_template('main.html')

@app.route('/makeroom', methods=['GET','POST'])
def makeroom():
    return render_template('makeroom.html')

if __name__ == '__main__':
    app.run(host='0.0.0.0',port=int('7000'))
