ex = "axbxa"

for i in range(len(ex)):
	if('x' in ex[i]):
		ex = ex[0:i]+ex[i+1:]+'x'	
	
print(ex)

