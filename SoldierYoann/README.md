											Soldats décorés


Nous allons nous intéresser ici à la modélisation des données associées à un jeu de type RTS (Real Time Strategy). Tout
d’abord, nous considérerons la mise en oeuvre de types différents de soldats selon la spécification informelle suivante :
– Les soldats disposeront de matériel d’armement qui sera au moins constitué de boucliers (shields) et d’épées
(swords).
– Il y aura au moins deux catégories de soldats : les fantassins (infantrymen ou footsoldiers) et les cavaliers (horsemen).
– La vivacité des soldats sera trivialement mesurée au moyen de “points de vie” ou “points de santé” (HealthPoints).
– Tout soldat sera capable de porter des coups (strike) à ses adversaires avec une efficacité qui dépend de l’armement
et de la catégorie du soldat, et qui réduira d’autant de points de vie celui qui les reçoit.
– Tout soldat sera capable de parer les coups (parry) de ses adversaires, dont l’efficacité dépend également de l’armement
et de la catégorie du soldat.



Exercice 1 : Pattern décorateur
1) Élaborer une architecture objet correspondant à la spécification ci-dessus (cette architecture doit permettre de créer
des soldats armés avec le matériel disponible).
2) Expliciter les diagrammes de séquence de construction de ces soldats, ainsi que ceux des méthodes strike et
parry.
3) Implémenter cette architecture tout en y ajoutant des tests unitaires.
4) Modifier l’implémentation de manière à pouvoir obtenir une trace de l’enchaînement des méthodes strike et
parry.


Exercice 2 : Pattern Proxy
1) Tenter d’imposer la contrainte suivante dans votre architecture : un soldat ne peut pas se voir doté de deux occurrences
à la fois du même armement.
2) Afin de donner une réponse effective à la dernière question, tenter d’utiliser le modèle de conception Procuration
(Proxy). Pour ce faire, on considérera une interface étendue qui contient des méthodes spécifiques d’ajoût d’armement
(c’est-à-dire addShield et addSword). Critiquer votre (vos) solution(s), et le cas échéant, concevoir une
alternative.
3) Modifier votre architecture de manière à ce que l’ajoût d’un nouveau type d’armement reste facile.