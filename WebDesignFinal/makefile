sync: 
	@aws s3 sync ./src s3://automotiveacquisitions.ie/

invalidate: 
	@aws cloudfront create-invalidation --distribution-id E2Z9ZX4IFBRHY4 --paths '/*'

deploy: sync invalidate

zip:
	zip -r seanwelch.zip ./*