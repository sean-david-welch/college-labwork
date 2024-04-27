build:
	@javac -d target src/*.java

run:
	@java -cp target EcommerceApp

deploy: build run

zip:
	zip -r seanwelch.zip . -x references.txt -x ".git/*" -x ".git" -x .gitignore
