# 1. Library imports
import uvicorn
from fastapi import FastAPI


from fastapi.middleware.cors import CORSMiddleware
import pickle


# 2. Create the app object
app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

#load the model
rgModel = pickle.load(open("rfcr.pkl", "rb"))


# 4. Index route, opens automatically on http://127.0.0.1:80
@app.get('/')
def index():
    return {'message': 'Hello World'}

@app.get("/predictresult")
def gePredictresult(age: int , gender: int , stream: int, internships: int  ,cgpa:int ,backlogs: int, codingskills: int ,aptitudeskills: int , technicalskills: int , communicationskills: int ):
   
    
    prediction = rgModel.predict([[age,gender,stream,internships,cgpa,backlogs,codingskills,aptitudeskills,technicalskills,communicationskills]])
    val = prediction[0];
    print(val);

    #return PlacedOrNot
    return [{
        'Result':str(val)
    }]


# 5. Run the API with uvicorn
#    Will run on http://127.0.0.1:80
if __name__ == '__main__':
    uvicorn.run(app, port=80, host='0.0.0.0')
    
#uvicorn app:app --reload

