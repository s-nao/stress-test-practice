from fastapi import APIRouter, Depends
from fastapi_jwt_auth import AuthJWT

router = APIRouter(
    prefix='/api/users',
    tags=['users']
)


@router.post("")
async def create():
    return {
        'data': {
            'name': 'test'
        }
    }


@router.get('', operation_id="authorize")
async def detail(authorize: AuthJWT = Depends()):
    authorize.jwt_required()

    current_user = authorize.get_jwt_subject()
    return {"user": current_user}

