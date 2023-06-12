# Twitter-Archiver-0.3
A simple program built using the [Spring](https://spring.io/) framework for Java that allows archiving tweets onto an Amazon Web Services [DynamoDB](https://aws.amazon.com/dynamodb/) database.
The frontend is built as a single-page-application using [React](https://react.dev/), and communicates to the REST API on the backend using [Axios](https://axios-http.com/).

## Setup
There are three steps in order to set up the Archiver.

### 1) Set up AWS credentials
There must be valid AWS credentials in the .aws folder in the home directory ~/.aws, typically in the form of file named config structured like below:

```
[default]
region = us-west-2
output = json
aws_access_key_id = accessKey
aws_secret_access_key = secretKey
```
Replace with the preferred region and the keys for the desired AWS account.


### 2) Set up application.properties file and add to .gitignore
Next you must create/edit an application.properties file that will store a bearer token - an alphanumeric key provided by the Twitter Developer Portal and required to access the Twitter API.

The application.properties file is used to set various properties in the Spring framework. In this case, it will allow us a place to store the bearer token that we can avoid publishing to git. The only field required is shown below:
```
bearer.token=${BEARER_TOKEN:bearerToken}
```
⚠️ **ADD THE FILE TO YOUR .gitignore!** Be sure you ignore this file in whatever version control system you are using in order to avoid publishing secret keys publicly. ⚠️

### 3) Build the front-end
You must have [Node Package Manager](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm) installed to properly build the frontend.
Once it is installed, navigate to the TwitterArchiver/frontend folder in your command line and run the following command:
```
npm run build
```
## Running
The backend sets up a local [Apache-Tomcat](https://tomcat.apache.org/) server (default port set to 8080) and is run from the App file in the src.main.java package.

The frontend is run by navigating to the TwitterArchiver/frontend folder in your command line and running the following command:
```
npm start
```
Once both components are running you should be able to view the app on the default frontend port at http://localhost:3000/ 

The current beta release prompts for a converted user id (roadmap includes allowing Twitter handle input directly). You can convert the Twitter handle (what is shown in the users profile URL) of the user you wish to archive tweets from into a converted user id at [this website](https://tweeterid.com/).

## Roadmap
- [x] Format README
- [x] Merge frontend
- [x] Archive Tweets by User
    - [ ] Add user input with Twitter handle directly instead of requiring user to convert it 
- [ ] Add additional features
    - [ ] Archive Followers by User
    - [ ] Archive Likes by Tweet
- [ ] Package frontend and backend into one-click solution (.jar? .exe?)
