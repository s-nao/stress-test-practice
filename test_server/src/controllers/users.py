from .application_controller import app


@app.route('/users', method='GET')
def show():
    return "show page"

@app.route('/users', method='POST')
def create():
    return "create page"
