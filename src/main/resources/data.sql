USE bibliotheques;

SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE bibliotheques.TBL_LIVRE;


INSERT INTO bibliotheques.TBL_LIVRE (id,title, author, publication,resume) VALUES
(1, 'Dune','FRANK HERBERT', '2018-04-28 02:45:30','livre de science fiction inspirée des space opéras et qui mélangent l"action, les intrigues et amour'),
(2, 'Fondation','ISAAC ASIMOV', '2019-04-28 02:45:30','livre de science fiction qui mélange les sciences et les intrigues'),
(3, 'Une poignée de seigle','AGATHA CHRISTIE', '2011-04-28 02:45:30','livre d"enquête policière'),
(4, 'la bicyclette bleue','REGINE DEFORGES', '2015-04-28 02:45:30','Roman qui raconte la vie d"une petite gamine cummulant les fragiltés d"une adolescente et les intrigues'),
(5, 'Le couteau sur la nuque','AGATHA CHRISTIE', '2007-04-28 02:45:30','livre d"enquête policière de Hercule Poirot'),
(6, 'Pourquoi pas Evans?','AGATHA CHRISTIE', '2005-04-28 02:45:30',' livre d"enquête policière'),
(7, 'El Trio de la Dama Negra','IRENE ADLER', '2018-04-28 02:45:30','livre d"enquête policière à la Sherlock'),
(8, 'Histoire d"Aladdin ou la lampe merveilleuse','ANTOINE GALLAND', '2001-04-28 02:45:30','livre pour enfants des contes des Mille et une Nuits'),
(9, 'Colomba et dix autres nouvelles','MERIMEE', '2000-04-28 02:45:30','livre de nouvelles de Mérimée dans l"ambiance du Sud de la France'),
(10, 'SAN ANTONIO Oeuvres Complètes Tome 2','FREDERIC DART', '1980-04-28 02:45:30','livre de 5 histoires de San Antonio'),
(11, 'Dune','FRANK HERBERT', '2018-06-28 02:45:30','livre de science fiction inspirée des space opéras et qui mélangent l"action, les intrigues et amour'),
(12, 'Dune','FRANK HERBERT', '2018-05-28 02:45:30','livre de science fiction inspirée des space opéras et qui mélangent l"action, les intrigues et amour');



SET FOREIGN_KEY_CHECKS=1;