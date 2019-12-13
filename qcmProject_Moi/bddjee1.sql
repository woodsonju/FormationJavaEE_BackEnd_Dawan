-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 28 Octobre 2019 à 22:29
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bddjee`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_qcms`
--

CREATE TABLE `t_qcms` (
  `idQcm` int(11) NOT NULL,
  `sujet` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `t_qcms`
--

INSERT INTO `t_qcms` (`idQcm`, `sujet`) VALUES
(1, 'One Piece'),
(2, 'La terre');

-- --------------------------------------------------------

--
-- Structure de la table `t_questions`
--

CREATE TABLE `t_questions` (
  `idQuestion` int(11) NOT NULL,
  `enonce` varchar(150) DEFAULT NULL,
  `idQcm` int(11) DEFAULT NULL,
  `ordre` int(11) DEFAULT NULL,
  `multiple` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `t_questions`
--

INSERT INTO `t_questions` (`idQuestion`, `enonce`, `idQcm`, `ordre`, `multiple`) VALUES
(1, 'Le One Piece existe t-il vraiment ?', 1, 1, 1),
(2, 'La terre est-elle plate ?', 2, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `t_reponses`
--

CREATE TABLE `t_reponses` (
  `idReponse` int(11) NOT NULL,
  `idQuestion` int(11) DEFAULT NULL,
  `texte` varchar(150) DEFAULT NULL,
  `correcte` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `t_reponses`
--

INSERT INTO `t_reponses` (`idReponse`, `idQuestion`, `texte`, `correcte`) VALUES
(1, 1, 'oui', 1),
(2, 1, 'non', 0),
(3, 2, 'sphéroïde', 1),
(4, 2, 'ellipsoïde', 1),
(5, 2, 'oblate ', 1),
(6, 2, 'plate', 0);

-- --------------------------------------------------------

--
-- Structure de la table `t_testqcm`
--

CREATE TABLE `t_testqcm` (
  `idTest` int(11) NOT NULL,
  `datePassage` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `idQcm` int(11) DEFAULT NULL,
  `idUtil` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtil` int(75) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `pwd` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtil`, `nom`, `email`, `pwd`) VALUES
(1, 'user1', 'user1@dawan.fr', 'user1'),
(2, 'user2', 'user2@dawan.fr', 'user2');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `t_qcms`
--
ALTER TABLE `t_qcms`
  ADD PRIMARY KEY (`idQcm`);

--
-- Index pour la table `t_questions`
--
ALTER TABLE `t_questions`
  ADD PRIMARY KEY (`idQuestion`),
  ADD KEY `idQcm` (`idQcm`);

--
-- Index pour la table `t_reponses`
--
ALTER TABLE `t_reponses`
  ADD PRIMARY KEY (`idReponse`),
  ADD KEY `idQuestion` (`idQuestion`);

--
-- Index pour la table `t_testqcm`
--
ALTER TABLE `t_testqcm`
  ADD PRIMARY KEY (`idTest`),
  ADD KEY `idQcm` (`idQcm`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtil`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `t_qcms`
--
ALTER TABLE `t_qcms`
  MODIFY `idQcm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `t_questions`
--
ALTER TABLE `t_questions`
  MODIFY `idQuestion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `t_reponses`
--
ALTER TABLE `t_reponses`
  MODIFY `idReponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `t_testqcm`
--
ALTER TABLE `t_testqcm`
  MODIFY `idTest` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtil` int(75) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `t_questions`
--
ALTER TABLE `t_questions`
  ADD CONSTRAINT `t_questions_ibfk_1` FOREIGN KEY (`idQcm`) REFERENCES `t_qcms` (`idQcm`),
  ADD CONSTRAINT `t_questions_ibfk_2` FOREIGN KEY (`idQcm`) REFERENCES `t_qcms` (`idQcm`);

--
-- Contraintes pour la table `t_reponses`
--
ALTER TABLE `t_reponses`
  ADD CONSTRAINT `t_reponses_ibfk_1` FOREIGN KEY (`idQuestion`) REFERENCES `t_questions` (`idQuestion`),
  ADD CONSTRAINT `t_reponses_ibfk_2` FOREIGN KEY (`idQuestion`) REFERENCES `t_questions` (`idQuestion`);

--
-- Contraintes pour la table `t_testqcm`
--
ALTER TABLE `t_testqcm`
  ADD CONSTRAINT `t_testqcm_ibfk_1` FOREIGN KEY (`idQcm`) REFERENCES `t_qcms` (`idQcm`),
  ADD CONSTRAINT `t_testqcm_ibfk_2` FOREIGN KEY (`idQcm`) REFERENCES `t_qcms` (`idQcm`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
