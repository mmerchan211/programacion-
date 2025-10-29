def calcular_media(lista):
    numeros = input(" Ingrese varios numeros separados por comas:")
    lista = [float(x.strip() for x in numeros.split(",")]
    if len (lista) == 0:
        print("No ingresaste ningun numero valido")
    else: 
    media = sum(lista) / len(lista)
    print("La media de los numeros es: {media}")

# llamar la función 
calcular_media()

