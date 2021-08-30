from .application_controller import app
from bottle import request, abort



@app.route("/search", method='POST')
def search():
    words = request.forms.get("words")
    abort(500, "go to 404")
    return "{data: %s}" % words
