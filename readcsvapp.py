import pandas as pd
import numpy as np
import os # Necesario para la verificación de la ruta

# --- 1. Lectura del Archivo de Entrada (CSV) ---

NOMBRE_ARCHIVO_ENTRADA = 'recetas_app_data.csv'
NOMBRE_ARCHIVO_SALIDA = 'recetas_app_data_limpio.csv'

print(f"--- 1. Leyendo datos de '{NOMBRE_ARCHIVO_ENTRADA}' ---")
try:
    df = pd.read_csv(NOMBRE_ARCHIVO_ENTRADA)
    print("DataFrame original (Primeras 5 filas):")
    print(df.head())
    print("\n" + "="*50 + "\n")
except FileNotFoundError:
    print(f"Error: Asegúrate de que '{NOMBRE_ARCHIVO_ENTRADA}' existe en la misma carpeta.")
    exit()

# 1. Limpieza de Espacios en Columnas de Texto
print("--- 2. Limpiando espacios al inicio/final en columnas de texto ---")
for col in df.select_dtypes(include=['object']).columns:
    df[col] = df[col].str.strip()

# 2. Normalizar y Sustituir Caracteres en 'Nombre_Receta'
# Eliminar acentos y unificar a minúsculas
print("--- 3. Normalizando y sustituyendo caracteres en 'Nombre_Receta' (ej: á -> a) ---")
df['Nombre_Receta'] = df['Nombre_Receta'].str.replace('á', 'a', regex=False).str.lower()
# Ejemplo de sustitución de un error de tipeo específico:
df['Nombre_Receta'] = df['Nombre_Receta'].str.replace('carboNara', 'carbonara', regex=False)


# 3. Sustituir valores nulos (NaN)
print("--- 4. Sustituyendo valores nulos (NaN) ---")

# a) Rellenar Nulos en 'Estado_Foro' con una categoría por defecto
df['Estado_Foro'] = df['Estado_Foro'].fillna('No Registrado')

# b) Rellenar Nulos en 'Cantidad_Disponible' con el valor más frecuente (moda)
# Primero, aseguramos que la columna sea numérica
df['Cantidad_Disponible'] = pd.to_numeric(df['Cantidad_Disponible'], errors='coerce')
moda_cantidad = df['Cantidad_Disponible'].mode()[0]
df['Cantidad_Disponible'] = df['Cantidad_Disponible'].fillna(moda_cantidad)

# 4. Sustitución condicional (Demostración de .replace())
# Unificar 'Lector Ocasional' con 'No Registrado' para simplificar
print("--- 5. Simplificando categorías de foro: 'Lector Ocasional' -> 'Inactivo' ---")
df['Estado_Foro'] = df['Estado_Foro'].replace({'Lector Ocasional': 'Inactivo'})

# 5. Crear columna de cálculo: Tiempo en Horas
# Columna 'Tiempo_Preparacion_horas' = Tiempo_Preparacion_min / 60
print("\n--- 6. Creando la columna 'Tiempo_Preparacion_horas' ---")
df['Tiempo_Preparacion_horas'] = df['Tiempo_Preparacion_min'] / 60

# 6. Crear una columna condicional usando np.where
# Clasificar la receta como 'Rápida' si dura menos de 30 min, sino 'Larga'
print("--- 7. Creando columna condicional 'Clasificacion_Receta' ---")
df['Clasificacion_Receta'] = np.where(df['Tiempo_Preparacion_min'] < 30, 'Rápida', 'Larga')

# 7. Búsqueda con máscara booleana: ¿Qué usuarios tienen 'Tomate' en su despensa?
print("--- 8. Búsqueda: Usuarios con 'Tomate' en la despensa ---")
df_tomate = df[df['Ingrediente_Despensa'] == 'Tomate']
print(f"Número de registros con Tomate: {len(df_tomate)}")
print("Ejemplo de IDs de usuario:", df_tomate['ID_Usuario'].unique()[:5])

# 8. Agrupación y Agregación: Calcular la cantidad media de ingredientes por estado del foro
print("\n--- 9. Agrupación: Media de Cantidad Disponible por Estado del Foro ---")
df_agrupado = df.groupby('Estado_Foro')['Cantidad_Disponible'].mean().reset_index()
df_agrupado.rename(columns={'Cantidad_Disponible': 'Media_Stock_Despensa'}, inplace=True)
print(df_agrupado)

print("\n" + "="*50 + "\n")
print(f"DataFrame Final Manipulado ({len(df)} filas):")
print(df.tail()) # Muestra las últimas 5 filas

# --- 3. Creación del Nuevo Fichero de Salida (CSV) ---
print(f"\n--- 10. Creando el nuevo fichero de salida: '{NOMBRE_ARCHIVO_SALIDA}' ---")
print(f"VERIFICACIÓN: La ruta de trabajo actual es: {os.getcwd()}") 

# Guardar el DataFrame manipulado en un nuevo archivo CSV
df.to_csv(NOMBRE_ARCHIVO_SALIDA, index=False, encoding='utf-8')

print(f"✅ Archivo '{NOMBRE_ARCHIVO_SALIDA}' creado con éxito.")