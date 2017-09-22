# kata-arolla


**Itération 2**
Aucun exemple de format pour la monnaie n'est donné dans cette itération, contrairement à la précédente ("T:1:0"...).
Voici donc ce que l'on va tester, avec comme format :    type:nbSucres:0:prix:montantInsere
* "T:1:0:0.40:0.0"			Un thé, avec un sucre, une touillette, pour un montant - nul donc insuffisant - de 0€, il manque donc 0.40€
* "T:2:0:0.40:0.40"			Un thé, avec deux sucres, une touillette, pour un montant - correct - de 0.40€
* "C:3:0:0.60:0.90"		Un café, avec  trois sucres, une touillette, pour un montant - trop élevé - de 0.90€
* "H:1:0:0.50:1.00"		Un chocolat, avec un sucre, une touillette, pour un montant - trop élevé - de 1€
* "H:2:0:0.50:0.20"		Un chocolat, avec deux sucres, une touillette, pour un montant - insuffisant - de 0.20€, il manque donc 0.30€
* "C:::0.60:0.70"			Un café, sans sucre, donc sans touillette, pour un montant - légèrement trop élevé - de 0.70€
* "C:::0.60:0.10"			Un café, sans sucre, donc sans touillette, pour un montant - insuffisant - de 0.10€, il manque donc 0.50€

**Oups** je n'avais pas vu que je ne devais pas me préoccuper de la monnaie... plan B
Format :    type:nbSucres:0
Tests :
* "T:1:0"			Un thé, avec un sucre, une touillette, pour un montant - nul donc insuffisant - de 0€
* "T:2:0"			Un thé, avec deux sucres, une touillette, pour un montant - correct - de 0.40€
* "C:3:0"			Un café, avec  trois sucres, une touillette, pour un montant - trop élevé - de 0.90€
* "H:1:0"			Un chocolat, avec un sucre, une touillette, pour un montant - trop élevé - de 1€
* "H:2:0:"		Un chocolat, avec deux sucres, une touillette, pour un montant - insuffisant - de 0.20€ (il manque donc 0.30€)
* "C:::"			Un café, sans sucre, donc sans touillette, pour un montant - légèrement trop élevé - de 0.70€ (0.10€ en trop)
* "C:::"			Un café, sans sucre, donc sans touillette, pour un montant - insuffisant - de 0.10€ (il manque donc 0.50€)


**Itération 3**
Format :    typeEtOptionTresChaud:nbSucres:0
Tests :
* "O::"			Un jus d'orange, pas de sucre, pas de touillette
* "Ch::"		Un café très chaud sans sucre ni touillette
* "Hh:1:0"	Un chocolat très chaud avec un sucre et une touillette
* "Th:2:0"	Un thé très chaud avec deux sucres et une touillette


**Itération 4**
Format du rapport :
Café 				nbCafe
Chocolat 			nbChocolat
Jus d'orange 	nbJusOrange
Thé 					nbThe
Total					total


**Itération 5**
Le rebuild de l'index de maven... o.O c'était assez long.
Utilisation de Mockito pour les tests.
Je n'ai pas réussi à faire deux tests :
* testGetMessageWithUnavailableBeverage:
    Je voulais tester unitairement la méthode mais le getMessage() ne sait pas à quel type de boisson il a affaire... donc ça ne marche pas.
* testOrderNoAvailableBeverage
    Je voulais vérifier que la notification était envoyée, ça fait partie de ce qui est demandé fonctionnelement, mais j'ignore comment faire avec Mockito


	
Merci pour le test, c'était sympa :)


