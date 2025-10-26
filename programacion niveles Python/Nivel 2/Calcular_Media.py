def calcular_media(lista):
    if not lista:
        print("La lista está vacía.")
        return
    media = sum(lista) / len(lista)
    print("La media es:", media)

# ejemplo
calcular_media([10, 18, 23, 30])
