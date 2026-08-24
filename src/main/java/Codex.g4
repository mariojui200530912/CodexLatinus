grammar Codex;

// Reglas Sintacticas

program : seccionVariables? seccionFunciones? seccionPrincipal EOF ;

seccionVariables : VARIABILES MAYOR declaracion* ;
seccionFunciones : MUNERA MAYOR funcion* ;
seccionPrincipal : MAIOR MAYOR instruccion* FINIS_MAIOR PUNTO_COMA? ;

tipoDato : NUMERUS | TEXTUM | DECIMALIS | LITTERA | BOOL | ID ;

declaracion : declaracionVar
            | declaracionArreglo
            | definicionStruct ;

declaracionVar : ESTO ID DOS_PUNTOS tipoDato ( expresion )? PUNTO_COMA ;

declaracionArreglo : SERIES ID CORCHETE_IZQ ENTERO CORCHETE_DER DOS_PUNTOS tipoDato ( LLAVE_IZQ expresion (COMA expresion)* LLAVE_DER )? PUNTO_COMA ;

atributoStruct : ESTO ID DOS_PUNTOS tipoDato expresion?
               | SERIES ID DOS_PUNTOS tipoDato (CORCHETE_IZQ ENTERO CORCHETE_DER)?
               ;

definicionStruct : STRUCTURA ID LLAVE_IZQ (atributoStruct (PUNTO_COMA | COMA)?)* LLAVE_DER FINIS PUNTO_COMA ;

funcion : (ACTIO | RATIO tipoDato) ID PAREN_IZQ parametros? PAREN_DER LLAVE_IZQ seccionVariablesLocal? instruccion* LLAVE_DER FINIS PUNTO_COMA ;

seccionVariablesLocal : VARIABILES CORCHETE_IZQ declaracionVar* CORCHETE_DER ;

parametros : parametro (COMA parametro)* ;
parametro : ESTO ID DOS_PUNTOS tipoDato ;

instruccion : declaracionVar
            | asignacion
            | estructuraControl
            | funcionEspecial
            | llamadaFuncion PUNTO_COMA
            | interrupcion
            | retorno;

interrupcion : ( PERGE | INTERRUMPE ) PUNTO_COMA ;

retorno : REDDERE expresion PUNTO_COMA ;

asignacion : ID ( PUNTO ID | CORCHETE_IZQ expresion CORCHETE_DER )* ASIGNACION expresion PUNTO_COMA ;

estructuraControl : condicionalSi
                  | cicloDum
                  | cicloFacere
                  | cicloPer ;

condicionalSi : SI PAREN_IZQ expresion PAREN_DER LLAVE_IZQ instruccion* LLAVE_DER
                (ALITER PAREN_IZQ expresion PAREN_DER LLAVE_IZQ instruccion* LLAVE_DER)*
                (ALITER LLAVE_IZQ instruccion* LLAVE_DER)? FINIS PUNTO_COMA ;

cicloDum : DUM PAREN_IZQ expresion PAREN_DER LLAVE_IZQ instruccion* LLAVE_DER FINIS PUNTO_COMA ;

cicloFacere : FACERE LLAVE_IZQ instruccion* LLAVE_DER DUM PAREN_IZQ expresion PAREN_DER PUNTO_COMA ;

cicloPer : PER PAREN_IZQ declaracionVar expresion PUNTO_COMA ID (MAS_MAS | MENOS_MENOS) PAREN_DER LLAVE_IZQ instruccion* LLAVE_DER ;

funcionEspecial : ID? LEER PUNTO_COMA?
                | IMPRIMIR expresion (IMPRIMIR expresion)* PUNTO_COMA? ;

expresion : MENOS expresion                               # exprUnaria
          | NON expresion                                 # exprNegacion
          | expresion (POR | DIV) expresion               # exprMultiplicacion
          | expresion (MAS | MENOS) expresion             # exprSuma
          | expresion (MAYOR | MENOR | MAYOR_IGUAL | MENOR_IGUAL) expresion # exprRelacional
          | expresion (IGUAL_IGUAL | DIFERENTE) expresion # exprIgualdad
          | expresion AND expresion                       # exprAnd
          | expresion OR expresion                        # exprOr
          | PAREN_IZQ expresion PAREN_DER                 # exprAgrupacion
          | ENTERO                                        # exprEntero
          | DECIMAL                                       # exprDecimal
          | CADENA                                        # exprCadena
          | CARACTER                                      # exprCaracter
          | VERUM                                         # exprVerdadero
          | FALSUS                                        # exprFalso
          | ID CORCHETE_IZQ expresion CORCHETE_DER        # exprArreglo
          | ID PUNTO ID                                   # exprAtributoStruct
          | llamadaFuncion                                # exprLlamada
          | ID                                            # exprVariable
          | ID? LLAVE_IZQ ( ID DOS_PUNTOS expresion COMA? )* LLAVE_DER #exprInstanciaStruct
          ;

llamadaFuncion : ID PAREN_IZQ (expresion (COMA expresion)*)? PAREN_DER ;


// Reglas Lexicas (LEXER)

// Tipos de Datos y Booleanos
NUMERUS    : 'numerus';
TEXTUM     : 'textum';
DECIMALIS  : 'decimalis';
LITTERA    : 'littera';
BOOL       : 'bool';
VERUM      : 'verum';
FALSUS     : 'falsus';

// Palabras Reservadas de Declaracion y Estructuras
ESTO       : 'esto';
SERIES     : 'series';
STRUCTURA  : 'structura';
FINIS      : 'finis';
FINIS_MAIOR : 'FINIS';

// Estructuras de Control de Flujo
SI         : 'si';
ALITER     : 'aliter';
DUM        : 'dum';
FACERE     : 'facere';
PER        : 'per';
PERGE      : 'perge';
INTERRUMPE : 'interrumpe';

// Funciones y Secciones
ACTIO      : 'actio';
RATIO      : 'ratio';
REDDERE    : 'reddere';
VARIABILES : 'VARIABILES';
MUNERA     : 'MUNERA';
MAIOR      : 'MAIOR';

// Operadores Logicos
NON        : 'non';

// Funciones Especiales del Sistema
LEER       : '<<';
IMPRIMIR   : '>>';

// Operadores Aritméticos y Relacionales
MAS_MAS    : '++';
MENOS_MENOS: '--';
MAS        : '+';
MENOS      : '-';
POR        : '*';
DIV        : '/';
IGUAL_IGUAL: '==';
DIFERENTE  : '!=';
MAYOR_IGUAL: '>=';
MENOR_IGUAL: '<=';
MAYOR      : '>';
MENOR      : '<';
AND        : '&&';
OR         : '||';

// Simbolos de Asignacion y Puntuacion
ASIGNACION : '=';
DOS_PUNTOS : ':';
PUNTO_COMA : ';';
COMA       : ',';
PUNTO      : '.';
PAREN_IZQ  : '(';
PAREN_DER  : ')';
LLAVE_IZQ  : '{';
LLAVE_DER  : '}';
CORCHETE_IZQ: '[';
CORCHETE_DER: ']';

// Expresiones Regulares para Literales e Identificadores
ID         : [a-zA-Z_][a-zA-Z0-9_]*;
ENTERO     : [0-9]+;
DECIMAL    : [0-9]+ '.' [0-9]+;
CADENA     : '"' .*? '"';
CARACTER   : '\'' . '\'';

// Reglas de Ignorado (Espacios y Comentarios)
COMMENT       : '//' ~[\r\n]* -> channel(HIDDEN);
BLOCK_COMMENT : '##' .*? '##' -> channel(HIDDEN);
WS            : [ \t\r\n]+ -> skip;