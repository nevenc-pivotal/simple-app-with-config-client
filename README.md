# simple-app-with-config-client

Simple example application that gets data from Config Server

<br/>
<br/>

## Create Config Server service instance

```
cf marketplace -s p-config-server
cf create-service p-config-server standard my-config-server -c '{"git": { "uri": "https://github.com/nevenc-pivotal/my-config-repo", "label": "master" }}'
```

> NOTE: Update `uri` with your own config server URL. You can use `ssh` in addition to `https`.  You will need to wait a minute or so, for the `my-config-server` service to be created.


Check again the service status:

```
cf my-config-server
```

<br/>
<br/>


## Build the application

```
mvn clean install
```

<br/>
<br/>

## Deploy the application to PCF

```
cf push
```

<br/>
<br/>

## Observe the environment variables

```
cf env simple-app-with-config-client
```

<br/>
<br/>

## Observe the logs

```
cf logs simple-app-with-config-client
```

<br/>
<br/>

## Test the application

```
curl -X GET -s https://simple-app-with-config-client.YOUR_PCF_DOMAIN
```

<br/>
<br/>

## Commit changes to Configuration Repository

Edit `my-config-repo:/greeting-service.properties` and update `greeting.message` to something else. Commit and push the changes, e.g.

```
vi my-config-repo/greeting-service.properties
git add greeting-service.properties
git commit greeting-service.properties
git push origin master
```
<br/>
<br/>

## Refresh the application

```
curl -X POST -s https://simple-app-with-config-client.YOUR_PCF_DOMAIN
```

<br/>
<br/>

## Test the application again

```
curl -X GET -s https://simple-app-with-config-client.YOUR_PCF_DOMAIN
```

<br/>
<br/>

