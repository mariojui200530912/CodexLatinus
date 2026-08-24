# Codex Latinus - El Compilador de la Resistencia

Codex Latinus es un compilador académico desarrollado en Java utilizando ANTLR 4. Diseñado para procesar un lenguaje con sintaxis inspirada en el latín, este proyecto implementa un analizador léxico, sintáctico y semántico estricto para garantizar que la lógica de la Resistencia se mantenga libre de corrupción. Además, incluye un módulo de traducción a *Pig Latin* para ofuscar las comunicaciones.

---

## Características Principales

*   **Análisis Léxico y Sintáctico (ANTLR 4):** Gramática robusta que procesa declaraciones, estructuras de control (`si`, `dum`, `facere`, `per`) y funciones.
*   **Árbol de Sintaxis Abstracta (AST):** Construcción dinámica mediante el patrón de diseño *Visitor*.
*   **Seguridad Semántica Estricta:**
    *   **Prevención de Corrupción de Flujo:** Exige tipos estrictamente booleanos (`bool`) en todas las condiciones de ciclos y estructuras de control.
    *   **Gestión de Ámbitos (Scopes):** Validación de variables locales, asegurando que solo se declaren al inicio de las funciones, protegiendo las estructuras de control anidadas.
    *   **Control de Funciones:** Diferenciación nativa entre procedimientos sin retorno (`actio`) y funciones con retorno estricto (`ratio`).
*   **Sistema de Tipos Estricto:** Promociones seguras implícitas (`numerus` a `decimalis`) y bloqueo de operaciones con pérdida de precisión o incompatibilidad total (ej. `textum` con `bool`).
*   **Traductor a Pig Latin:** Módulo de transformación de código fuente validado hacia un formato ofuscado.
*   **Visualización (JGraphX):** Generación de representaciones gráficas de los árboles sintácticos.

---

## Tecnologías y Herramientas

*   **Lenguaje:** Java 21
*   **Generador de Parsers:** ANTLR 4.13.2
*   **Gestor de Dependencias:** Apache Maven 3.13.0
*   **Librerías Adicionales:** JGraphX (Graficación del AST)

---

## Instalación y Ejecución

### Prerrequisitos
*   Java Development Kit (JDK) 21 instalado.
*   Apache Maven configurado en las variables de entorno.

### Compilación y Empaquetado
Para limpiar construcciones previas, generar los archivos de ANTLR y compilar el proyecto en un ejecutable *Fat-JAR* con todas las dependencias, ejecuta el siguiente comando en la raíz del proyecto:

```bash
mvn clean package