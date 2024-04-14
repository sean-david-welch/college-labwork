sync: 
	@aws s3 sync ./dist s3://automotiveacquisitions.ie/

invalidate: 
	@aws cloudfront create-invalidation --distribution-id EGIJU0OVG257E --paths '/*'

deploy: build invalidate
