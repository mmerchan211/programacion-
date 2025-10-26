def contador_vocales():
    s = input("Ingrese una cadena: ")
    vocales = set("aeiouáéíóúAEIOUÁÉÍÓÚ")
    contador = sum(1 for ch in s if ch in vocales)
    print("Número de vocales:", contador)
    return contador

if __name__ == "__main__":
    contador_vocales()
