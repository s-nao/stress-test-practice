# coding:utf-8

import os, sys # 一つ上の階層をrootをしたいので
sys.path.append(os.getcwd())

from bottle import Bottle, error

import controllers


@error(500)
def error500(error):
    return "Server Error"

if __name__ == "__main__":
    app: Bottle = Bottle()

    app.mount('/api', controllers.users.app)
    app.mount('/api', controllers.search.app)


    app.run(host='localhost', port=8081, debug=True, reloader=True)
