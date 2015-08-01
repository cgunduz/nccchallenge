
curl localhost:8080/isp/all
curl localhost:8080/isp/companyName/xyz
curl -H "Content-Type: application/json" -X POST -d '{"companyName":"xyz","website":"atlar"}' http://localhost:8080/isp/register
