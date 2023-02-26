
from fastapi import APIRouter, Depends, HTTPException
from fastapi_jwt_auth import AuthJWT

from ..schemas.user import User

router = APIRouter(
    prefix='/api/auth',
    tags=['authentication']
)


@router.post('/login')
def login(user: User, authorize: AuthJWT = Depends()):
    if user.username != "test" or user.password != "test":
        raise HTTPException(status_code=401,detail="Bad username or password")

    access_token = authorize.create_access_token(subject=user.username)
    return {"access_token": access_token}