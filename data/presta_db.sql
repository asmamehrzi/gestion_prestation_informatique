--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: app_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_role (
    id bigint NOT NULL,
    role_name character varying(255)
);


ALTER TABLE public.app_role OWNER TO postgres;

--
-- Name: app_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.app_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.app_role_id_seq OWNER TO postgres;

--
-- Name: app_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.app_role_id_seq OWNED BY public.app_role.id;


--
-- Name: app_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_user (
    id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.app_user OWNER TO postgres;

--
-- Name: app_user_app_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_user_app_roles (
    app_user_id bigint NOT NULL,
    app_roles_id bigint NOT NULL
);


ALTER TABLE public.app_user_app_roles OWNER TO postgres;

--
-- Name: app_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.app_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.app_user_id_seq OWNER TO postgres;

--
-- Name: app_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.app_user_id_seq OWNED BY public.app_user.id;


--
-- Name: candidat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidat (
    id bigint NOT NULL,
    nbr_exp bigint NOT NULL,
    adresse character varying(255),
    email character varying(255),
    nom character varying(255),
    password character varying(255),
    prenom character varying(255),
    statut boolean
);


ALTER TABLE public.candidat OWNER TO postgres;

--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id bigint NOT NULL,
    email character varying(255),
    nom_entreprise character varying(255),
    password character varying(255),
    pays character varying(255),
    siret bigint,
    tel bigint
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: competance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.competance (
    id bigint NOT NULL,
    description character varying(255),
    nom_competance character varying(255),
    consultant_id bigint,
    domaine_id bigint
);


ALTER TABLE public.competance OWNER TO postgres;

--
-- Name: competance_condidatures; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.competance_condidatures (
    competances_id bigint NOT NULL,
    condidatures_id bigint NOT NULL
);


ALTER TABLE public.competance_condidatures OWNER TO postgres;

--
-- Name: competance_consultants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.competance_consultants (
    competancescoll_id bigint NOT NULL,
    consultants_id bigint NOT NULL
);


ALTER TABLE public.competance_consultants OWNER TO postgres;

--
-- Name: condidature; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.condidature (
    id bigint NOT NULL,
    cv character varying(255),
    email character varying(255),
    pays character varying(255),
    prenom character varying(255),
    tel character varying(255),
    consultant_id bigint
);


ALTER TABLE public.condidature OWNER TO postgres;

--
-- Name: consultant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultant (
    id bigint NOT NULL,
    email character varying(255),
    lname character varying(255),
    name character varying(255),
    password character varying(255),
    pays character varying(255),
    tel character varying(255),
    typeconsultant_id bigint
);


ALTER TABLE public.consultant OWNER TO postgres;

--
-- Name: demander; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.demander (
    id bigint NOT NULL,
    nbre_ann_exp bigint NOT NULL
);


ALTER TABLE public.demander OWNER TO postgres;

--
-- Name: domaine; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.domaine (
    id bigint NOT NULL,
    nom_domaine character varying(255)
);


ALTER TABLE public.domaine OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: mission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mission (
    id bigint NOT NULL,
    adresse character varying(255),
    datedebut timestamp without time zone,
    description character varying(255),
    duration character varying(255),
    client_id bigint,
    typemission_id bigint
);


ALTER TABLE public.mission OWNER TO postgres;

--
-- Name: mission_competances; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mission_competances (
    missions_id bigint NOT NULL,
    competances_id bigint NOT NULL
);


ALTER TABLE public.mission_competances OWNER TO postgres;

--
-- Name: mission_consultants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mission_consultants (
    missions_id bigint NOT NULL,
    consultants_id bigint NOT NULL
);


ALTER TABLE public.mission_consultants OWNER TO postgres;

--
-- Name: profil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profil (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(255),
    consultant_id bigint
);


ALTER TABLE public.profil OWNER TO postgres;

--
-- Name: type_condidature; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_condidature (
    id bigint NOT NULL,
    type_condidature character varying(255)
);


ALTER TABLE public.type_condidature OWNER TO postgres;

--
-- Name: type_consultant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_consultant (
    id bigint NOT NULL,
    type_consultant character varying(255)
);


ALTER TABLE public.type_consultant OWNER TO postgres;

--
-- Name: type_mission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_mission (
    id bigint NOT NULL,
    type_mission character varying(255)
);


ALTER TABLE public.type_mission OWNER TO postgres;

--
-- Name: typecandidature; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.typecandidature (
    id bigint NOT NULL,
    nom_type character varying(255)
);


ALTER TABLE public.typecandidature OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    function character varying(255),
    lname character varying(255),
    login character varying(255),
    name character varying(255),
    password character varying(255),
    siret integer,
    status character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: app_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_role ALTER COLUMN id SET DEFAULT nextval('public.app_role_id_seq'::regclass);


--
-- Name: app_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user ALTER COLUMN id SET DEFAULT nextval('public.app_user_id_seq'::regclass);


--
-- Data for Name: app_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_role (id, role_name) FROM stdin;
1	USER
2	ADMIN
3	CUSTOMER_MANAGER
4	PRODUCT_MANAGER
5	BILLS_MANAGER
\.


--
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_user (id, email, password, username) FROM stdin;
1	\N	$2a$10$XPtfb7hMNrt6TnDET65dCu1ZfclXiPFQ1ZmXCpKEOxNXP3zWFDXy2	user1
2	\N	$2a$10$UQPokV5G63.Dpm9LgU9iaepy.4hxxUDSHS9dKDw50V0o11NWlMLnK	admin
3	\N	$2a$10$1oDZD7wnExTB73/geb5EUePxJrn2vN9GKDrlIAdJbWJfGk/wYG2kK	user2
4	\N	$2a$10$HCQ9tEa9higyx/k0bJF58.OX4Wj.PpOmqGWakbOKEW8kA0M3q9RdO	user3
5	\N	$2a$10$tHvDFux2M7spAkVB.0sVx.pvKHgE9y3xoi3DlgYvXXRZLtP0o7x5W	user4
\.


--
-- Data for Name: app_user_app_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_user_app_roles (app_user_id, app_roles_id) FROM stdin;
2	1
2	2
3	1
3	3
4	1
4	4
5	1
1	1
1	5
\.


--
-- Data for Name: candidat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.candidat (id, nbr_exp, adresse, email, nom, password, prenom, statut) FROM stdin;
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id, email, nom_entreprise, password, pays, siret, tel) FROM stdin;
\.


--
-- Data for Name: competance; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.competance (id, description, nom_competance, consultant_id, domaine_id) FROM stdin;
\.


--
-- Data for Name: competance_condidatures; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.competance_condidatures (competances_id, condidatures_id) FROM stdin;
\.


--
-- Data for Name: competance_consultants; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.competance_consultants (competancescoll_id, consultants_id) FROM stdin;
\.


--
-- Data for Name: condidature; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.condidature (id, cv, email, pays, prenom, tel, consultant_id) FROM stdin;
\.


--
-- Data for Name: consultant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consultant (id, email, lname, name, password, pays, tel, typeconsultant_id) FROM stdin;
\.


--
-- Data for Name: demander; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.demander (id, nbre_ann_exp) FROM stdin;
\.


--
-- Data for Name: domaine; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.domaine (id, nom_domaine) FROM stdin;
\.


--
-- Data for Name: mission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mission (id, adresse, datedebut, description, duration, client_id, typemission_id) FROM stdin;
\.


--
-- Data for Name: mission_competances; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mission_competances (missions_id, competances_id) FROM stdin;
\.


--
-- Data for Name: mission_consultants; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mission_consultants (missions_id, consultants_id) FROM stdin;
\.


--
-- Data for Name: profil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profil (id, description, name, consultant_id) FROM stdin;
\.


--
-- Data for Name: type_condidature; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_condidature (id, type_condidature) FROM stdin;
\.


--
-- Data for Name: type_consultant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_consultant (id, type_consultant) FROM stdin;
\.


--
-- Data for Name: type_mission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_mission (id, type_mission) FROM stdin;
\.


--
-- Data for Name: typecandidature; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.typecandidature (id, nom_type) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, function, lname, login, name, password, siret, status) FROM stdin;
\.


--
-- Name: app_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.app_role_id_seq', 5, true);


--
-- Name: app_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.app_user_id_seq', 5, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: app_role app_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_role
    ADD CONSTRAINT app_role_pkey PRIMARY KEY (id);


--
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);


--
-- Name: candidat candidat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidat
    ADD CONSTRAINT candidat_pkey PRIMARY KEY (id);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: competance competance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competance
    ADD CONSTRAINT competance_pkey PRIMARY KEY (id);


--
-- Name: condidature condidature_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.condidature
    ADD CONSTRAINT condidature_pkey PRIMARY KEY (id);


--
-- Name: consultant consultant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultant
    ADD CONSTRAINT consultant_pkey PRIMARY KEY (id);


--
-- Name: demander demander_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.demander
    ADD CONSTRAINT demander_pkey PRIMARY KEY (id);


--
-- Name: domaine domaine_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.domaine
    ADD CONSTRAINT domaine_pkey PRIMARY KEY (id);


--
-- Name: mission mission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT mission_pkey PRIMARY KEY (id);


--
-- Name: profil profil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profil
    ADD CONSTRAINT profil_pkey PRIMARY KEY (id);


--
-- Name: type_condidature type_condidature_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_condidature
    ADD CONSTRAINT type_condidature_pkey PRIMARY KEY (id);


--
-- Name: type_consultant type_consultant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_consultant
    ADD CONSTRAINT type_consultant_pkey PRIMARY KEY (id);


--
-- Name: type_mission type_mission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_mission
    ADD CONSTRAINT type_mission_pkey PRIMARY KEY (id);


--
-- Name: typecandidature typecandidature_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typecandidature
    ADD CONSTRAINT typecandidature_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: consultant fk4ypwp5ogra4u1hp6gyqqsrj6n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultant
    ADD CONSTRAINT fk4ypwp5ogra4u1hp6gyqqsrj6n FOREIGN KEY (typeconsultant_id) REFERENCES public.type_consultant(id);


--
-- Name: mission_competances fk6jt0e3mgskjuov8mpw5xchoxr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission_competances
    ADD CONSTRAINT fk6jt0e3mgskjuov8mpw5xchoxr FOREIGN KEY (missions_id) REFERENCES public.mission(id);


--
-- Name: app_user_app_roles fk8caosscox5onsgcvll6tqmk21; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user_app_roles
    ADD CONSTRAINT fk8caosscox5onsgcvll6tqmk21 FOREIGN KEY (app_roles_id) REFERENCES public.app_role(id);


--
-- Name: mission_competances fka8960uh9agn3k26cxrnp6vimr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission_competances
    ADD CONSTRAINT fka8960uh9agn3k26cxrnp6vimr FOREIGN KEY (competances_id) REFERENCES public.competance(id);


--
-- Name: mission_consultants fkagm15pb5b4cnfng003w8587is; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission_consultants
    ADD CONSTRAINT fkagm15pb5b4cnfng003w8587is FOREIGN KEY (consultants_id) REFERENCES public.consultant(id);


--
-- Name: condidature fkasgm3t9axunj4va7najxe0cc0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.condidature
    ADD CONSTRAINT fkasgm3t9axunj4va7najxe0cc0 FOREIGN KEY (consultant_id) REFERENCES public.consultant(id);


--
-- Name: competance fkcrj2cehnx1yml20s7914jcurt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competance
    ADD CONSTRAINT fkcrj2cehnx1yml20s7914jcurt FOREIGN KEY (consultant_id) REFERENCES public.consultant(id);


--
-- Name: mission fkghfk6lxd25qr5tt9plvxymxun; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT fkghfk6lxd25qr5tt9plvxymxun FOREIGN KEY (typemission_id) REFERENCES public.type_mission(id);


--
-- Name: competance_consultants fkj5cyebscmbrxsp6xgetvmeib4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competance_consultants
    ADD CONSTRAINT fkj5cyebscmbrxsp6xgetvmeib4 FOREIGN KEY (competancescoll_id) REFERENCES public.competance(id);


--
-- Name: mission_consultants fkkvbq6x425arix704tod7joqbp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission_consultants
    ADD CONSTRAINT fkkvbq6x425arix704tod7joqbp FOREIGN KEY (missions_id) REFERENCES public.mission(id);


--
-- Name: competance_consultants fkliuh0f8b06vv40v0ap7cry3hu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competance_consultants
    ADD CONSTRAINT fkliuh0f8b06vv40v0ap7cry3hu FOREIGN KEY (consultants_id) REFERENCES public.consultant(id);


--
-- Name: mission fkoadm6khv9xh2ei3oee70hqh2l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT fkoadm6khv9xh2ei3oee70hqh2l FOREIGN KEY (client_id) REFERENCES public.client(id);


--
-- Name: app_user_app_roles fksno3iwx8ppdc085g7ovuc8h7w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user_app_roles
    ADD CONSTRAINT fksno3iwx8ppdc085g7ovuc8h7w FOREIGN KEY (app_user_id) REFERENCES public.app_user(id);


--
-- Name: competance fkt9drbsl33polxiepvtg8kitud; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competance
    ADD CONSTRAINT fkt9drbsl33polxiepvtg8kitud FOREIGN KEY (domaine_id) REFERENCES public.domaine(id);


--
-- PostgreSQL database dump complete
--

