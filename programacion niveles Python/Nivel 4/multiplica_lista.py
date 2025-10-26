def multiplicar_lista(lista, numero):
    nueva_lista = [x * numero for x in lista]
    return nueva_lista


print("Nueva lista:", multiplicar_lista([87, 15, 8], 4))  
