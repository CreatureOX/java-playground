@echo off
set root=%cd%
set version=0.0.1-SNAPSHOT

@echo off
start cmd /c "title eureka server && java -jar %root%\eureka-server\target\eureka-server-%version%.jar"

@echo off
start cmd /c "title eureka client && java -jar %root%\eureka-client\target\eureka-client-%version%.jar"
