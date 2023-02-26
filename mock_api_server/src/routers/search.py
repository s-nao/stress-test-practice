from fastapi import APIRouter

router = APIRouter(
    prefix='/api/search',
    tags=['search']
)
@router.get('')
async def search():
    return {'data': 'aaaaa!'}