grammar Toml;

toml
  : (' '* toml_stat)+
  ;

toml_stat
  : section NEWLINE
  | toml_assignment ' '* (comment)? NEWLINE
  | comment NEWLINE
  | NEWLINE
  ;

section
  : '[' WORD ']'
  ;

comment
  : '#' ~(NEWLINE)*
  ;

toml_assignment
  : WORD ' '* '=' ' '* NUMBER      # Integer
  | WORD ' '* '=' ' '* BOOLEAN     # Boolean
  | WORD ' '* '=' ' '* DATE        # Date
  | WORD ' '* '=' ' '* STRING      # String
  | WORD ' '* '=' ' '* array       # List
  ;

literal_expr
  : NUMBER
  | BOOLEAN
  | DATE
  | STRING
  ;

array
  : '[' ' '* (array|literal_expr) ' '* (',' ' '* (array|literal_expr))* ' '* ']'
  ;

NUMBER: [0-9]+(\.[0-9]+)? ;
BOOLEAN: ('true'|'false') ;
WORD : [\.a-zA-Z0-9_\-&\\#\?\'\t\n!]+ ;
STRING : '"' WORD (' ' WORD)* '"' ;
DATE: [0-9][0-9][0-9][0-9]'-'[0-9][0-9]'-'[0-9][0-9]'T'[0-9][0-9]':'[0-9][0-9]':'[0-9][0-9]'Z' ;
NEWLINE : '\r'?'\n' ;
