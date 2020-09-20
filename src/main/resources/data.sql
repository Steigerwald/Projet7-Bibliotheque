USE bibliotheques;

SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE bibliotheques.TBL_LIVRE;
TRUNCATE TABLE bibliotheques.TBL_BIBLIOTHEQUE;

INSERT INTO bibliotheques.TBL_LIVRE (id_livre,titre, auteur, publication,resume,nombre_pages,nom_categorie,date_achat,prix_location,etat_livre,disponibilite) VALUES
(1, 'Dune','FRANK HERBERT', '2018-04-28 02:45:30','livre de science fiction inspirée des space opéras et qui mélangent l"action, les intrigues et amour',320,'Science Fiction','2018-04-28 02:45:30',10,'neuf',true),
(2, 'Fondation','ISAAC ASIMOV', '2019-04-28 02:45:30','livre de science fiction qui mélange les sciences et les intrigues',290,'Science Fiction','2019-04-28 02:45:30',10,'neuf',true),
(3, 'Une poignée de seigle','AGATHA CHRISTIE', '2011-04-28 02:45:30','livre d"enquête policière',242,'Policier','2011-04-28 02:45:30',10,'neuf',true),
(4, 'la bicyclette bleue','REGINE DEFORGES', '2015-04-28 02:45:30','Roman qui raconte la vie d"une petite gamine cummulant les fragiltés d"une adolescente et les intrigues',463,'Roman','2015-04-28 02:45:30',15,'normal',false),
(5, 'Le couteau sur la nuque','AGATHA CHRISTIE', '2007-04-28 02:45:30','livre d"enquête policière de Hercule Poirot',247,'Policier','2007-04-28 02:45:30',10,'normal',true),
(6, 'Pourquoi pas Evans?','AGATHA CHRISTIE', '2005-04-28 02:45:30',' livre d"enquête policière',246,'Policier','2005-04-28 02:45:30',10,'normal',true),
(7, 'El Trio de la Dama Negra','IRENE ADLER', '2018-04-28 02:45:30','livre d"enquête policière à la Sherlock',259,'Policier','2018-04-28 02:45:30',10,'normal',true),
(8, 'Histoire d"Aladdin ou la lampe merveilleuse','ANTOINE GALLAND', '2001-04-28 02:45:30','livre pour enfants des contes des Mille et une Nuits',169,'Comtes','2001-04-28 02:45:30',10,'normal',true),
(9, 'Colomba et dix autres nouvelles','MERIMEE', '2000-04-28 02:45:30','livre de nouvelles de Mérimée dans l"ambiance du Sud de la France',479,'Nouvelles','2000-04-28 02:45:30',15,'normal',false),
(10, 'SAN ANTONIO Oeuvres Complètes Tome 2','FREDERIC DART', '1980-04-28 02:45:30','livre de 5 histoires de San Antonio',635,'Policier','1980-04-28 02:45:30',20,'vieux',true),
(11, 'Dune','FRANK HERBERT', '2018-06-28 02:45:30','livre de science fiction inspirée des space opéras et qui mélangent l"action, les intrigues et amour',320,'Science Fiction','2018-06-28 02:45:30',10,'neuf',false),
(12, 'Dune','FRANK HERBERT', '2018-05-28 02:45:30','livre de science fiction inspirée des space opéras et qui mélangent l"action, les intrigues et amour',320,'Science Fiction','2018-05-28 02:45:30',10,'normal',false);


INSERT INTO bibliotheques.TBL_BIBLIOTHEQUE (id_bibliotheque, adresse, lieu, nom_bibliotheque) VALUES
(1, '140 AVENUE CHARLES DE GAULLE', 'BRUGES', 'ESPACE DE BRUGES'),
(2, '38 RUE EMILE COUDORD', 'BORDEAUX', 'ESPACE CULTUREL DE BORDEAUX'),
(3, '50 AVENUE GENERAL LECLERC', 'LE BOUSCAT', 'TECHNOSPACE CULTUREL');



SET FOREIGN_KEY_CHECKS=1;