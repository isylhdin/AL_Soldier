											Soldats d�cor�s


Nous allons nous int�resser ici � la mod�lisation des donn�es associ�es � un jeu de type RTS (Real Time Strategy). Tout
d�abord, nous consid�rerons la mise en oeuvre de types diff�rents de soldats selon la sp�cification informelle suivante :
� Les soldats disposeront de mat�riel d�armement qui sera au moins constitu� de boucliers (shields) et d��p�es
(swords).
� Il y aura au moins deux cat�gories de soldats : les fantassins (infantrymen ou footsoldiers) et les cavaliers (horsemen).
� La vivacit� des soldats sera trivialement mesur�e au moyen de �points de vie� ou �points de sant� (HealthPoints).
� Tout soldat sera capable de porter des coups (strike) � ses adversaires avec une efficacit� qui d�pend de l�armement
et de la cat�gorie du soldat, et qui r�duira d�autant de points de vie celui qui les re�oit.
� Tout soldat sera capable de parer les coups (parry) de ses adversaires, dont l�efficacit� d�pend �galement de l�armement
et de la cat�gorie du soldat.



Exercice 1 : Pattern d�corateur
1) �laborer une architecture objet correspondant � la sp�cification ci-dessus (cette architecture doit permettre de cr�er
des soldats arm�s avec le mat�riel disponible).
2) Expliciter les diagrammes de s�quence de construction de ces soldats, ainsi que ceux des m�thodes strike et
parry.
3) Impl�menter cette architecture tout en y ajoutant des tests unitaires.
4) Modifier l�impl�mentation de mani�re � pouvoir obtenir une trace de l�encha�nement des m�thodes strike et
parry.


Exercice 2 : Pattern Proxy
1) Tenter d�imposer la contrainte suivante dans votre architecture : un soldat ne peut pas se voir dot� de deux occurrences
� la fois du m�me armement.
2) Afin de donner une r�ponse effective � la derni�re question, tenter d�utiliser le mod�le de conception Procuration
(Proxy). Pour ce faire, on consid�rera une interface �tendue qui contient des m�thodes sp�cifiques d�ajo�t d�armement
(c�est-�-dire addShield et addSword). Critiquer votre (vos) solution(s), et le cas �ch�ant, concevoir une
alternative.
3) Modifier votre architecture de mani�re � ce que l�ajo�t d�un nouveau type d�armement reste facile.