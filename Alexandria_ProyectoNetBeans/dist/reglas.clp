(deffacts hechosDeControl
	(Usuario)
	(limpieza no)
	(sinRespuesta si)
)

(defrule vetarAutores
	(declare (salience 100))
	(limpieza no)
	(Libro (titulo ?tit)(autores $? ?autor $?))
	(Usuario (autoresVetados $? ?autor $?))
	=>
	(assert (libroVetado ?tit))
)

(defrule vetarGeneros
	(declare (salience 100))
	(limpieza no)
	(Libro (titulo ?tit)(generos $? ?genero $?))
	(Usuario (generosVetados $? ?genero $?))
	=>
	(assert (libroVetado ?tit))
)

(defrule similarMismoAutor
	(limpieza no)
	(Libro (titulo ?tit1)(autores $? ?x $?))
	(Libro (titulo ?tit2)(autores $? ?x $?))
	(not (eq ?tit1 ?tit2))
	(not (similar ?tit1 ?tit2))
	=>
	(assert (similar ?tit1 ?tit2))
	(assert (similar ?tit2 ?tit1))
)

(defrule similarMismoGenero
	(limpieza no)
	(Libro (titulo ?tit1)(generos $? ?x $?))
	(Libro (titulo ?tit2)(generos $? ?x $?))
	(not (similar ?tit1 ?tit2))
	(not (eq ?tit1 ?tit2))
	=>
	(assert (similar ?tit1 ?tit2))
	(assert (similar ?tit2 ?tit1))
)

(defrule recomendarPorFavoritos
	(limpieza no)
	(Libro (titulo ?titFav)(favorito si))
	?c <- (Libro (titulo ?candidato)(recomendado no))
	(similar ?titFav ?candidato)
	(not (libroVetado ?candidato))
	=>
	(modify ?c (recomendado si))
)

(defrule recomendarPorAutor
	(limpieza no)
	(Usuario (autoresFavoritos $? ?aut $?))
	?c <- (Libro (titulo ?tit)(autores $? ?aut $?)(recomendado no))
	(not (libroVetado ?tit))
	=>
	(modify ?c (recomendado si))
)

(defrule recomendarPorGenero
	(limpieza no)
	(Usuario (generosFavoritos $? ?gen $?))
	?c <- (Libro (titulo ?tit)(generos $? ?gen $?)(recomendado no))
	(not (libroVetado ?tit))
	=>
	(modify ?c (recomendado si))
)

(defrule actualizarFavoritos
	(limpieza no)
	?l <- (Libro (titulo ?tit))
	?a <- (actualizarFav ?tit ?val)
	=>
	(modify ?l (favorito ?val))
	(retract ?a)
)

(deffunction es-miembro (?candidato ?lista)
	(loop-for-count (?i 1 (length$ ?lista)) do
		(if (eq 1 (regex_match ?candidato (nth$ ?i ?lista))) then 
			(return 1)
		)
	)
	(return 0)
)

(defrule checkSinRespuesta
	(limpieza no)
	(Libro (recomendado si))
	?borrar <- (sinRespuesta si)
	=>
	(retract ?borrar)
	(assert (sinRespuesta no))
)

;;; Reglas de filtro y control

(defrule limpiarVetos
	(limpieza si)
	?borrar <- (libroVetado ?)
	=>
	(retract ?borrar)
)

(defrule limpiarRecomendaciones
	(limpieza si)
	?l <- (Libro (recomendado si))
	?borrar <- (sinRespuesta ?)
	=>
	(modify ?l (recomendado no))
	(retract ?borrar)
	(assert (sinRespuesta si))
)