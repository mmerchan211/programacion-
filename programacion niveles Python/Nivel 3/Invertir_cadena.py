def invertir_cadena(cadena: str) -> str:
    return cadena[::-1]

# main 
if __name__ == "__main__":
    entrada = input("Ingrese una cadena para invertir: ")
    resultado = invertir_cadena(entrada)
    print("Cadena invertida:", resultado)
