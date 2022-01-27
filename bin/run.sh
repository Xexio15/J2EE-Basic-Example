sudo docker ps -q --filter ancestor="j2eedemo" | xargs -r sudo docker stop
sudo docker build . -t j2eedemo
sudo docker run -d -p 8090:8080 j2eedemo