def Palindromo(palabra):  
 for i in range(0,int(len(palabra)/2)): #Es suficiente con analizar la mitad  
  if palabra[i]!=palabra[-i-1]:
   return False
 return True
palabra=input('Escriba una palabra: ').lower()  
print(palabra, '¿es un palindromo?',Palindromo(palabra))  