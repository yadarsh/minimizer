# minimizer

This problem takes an input string and replaces identifiers with shorter ones.
A function that takes input string containing source code and finds and replaces duplicate identifiers and returns the resulting string. 

Assumptions: 
No need to handle file input/output
An identifier is a string of letters only. 
For example: "Alice" is a single identifier while "jump4joy" is the identifier "jump", the non-identifier "4" and a second identifier "joy".

The second and subsequent times each identifier appears it is replaced by a dollar sign and a number which is the index of the first appearance of that identifier, counting the first identifier as 0, the next as 1, etc. Anything that is not an identifier is output as is and there is no need to parse the non-identifier parts.
For example: 
minimize("you say yes, I say no you say stop and I say go go go") => "you say yes, I $1 no $0 $1 stop and $3 $1 go $12 $12
