PGDMP      1                }            postgres    17.4    17.4 �               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false                       1262    5    postgres    DATABASE     n   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'vi-VN';
    DROP DATABASE postgres;
                     postgres    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                        postgres    false    5126            �            1259    24684    category    TABLE     z   CREATE TABLE public.category (
    categoryid integer NOT NULL,
    name character varying(255),
    productid integer
);
    DROP TABLE public.category;
       public         heap r       postgres    false            �            1259    24687    category_categoryid_seq    SEQUENCE     �   CREATE SEQUENCE public.category_categoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.category_categoryid_seq;
       public               postgres    false    217                       0    0    category_categoryid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.category_categoryid_seq OWNED BY public.category.categoryid;
          public               postgres    false    218            �            1259    24688    consignment    TABLE     $  CREATE TABLE public.consignment (
    consignmentid integer NOT NULL,
    sku character varying(255),
    name character varying(255),
    description text,
    totalquantity integer,
    totalprice numeric,
    importdate date,
    status text,
    supplierid integer,
    userid integer
);
    DROP TABLE public.consignment;
       public         heap r       postgres    false            �            1259    24693    consignment_consignmentid_seq    SEQUENCE     �   CREATE SEQUENCE public.consignment_consignmentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.consignment_consignmentid_seq;
       public               postgres    false    219            	           0    0    consignment_consignmentid_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.consignment_consignmentid_seq OWNED BY public.consignment.consignmentid;
          public               postgres    false    220            �            1259    24694    customer    TABLE       CREATE TABLE public.customer (
    customerid integer NOT NULL,
    name character varying(255),
    address text,
    phone character varying(20),
    email character varying(255),
    status boolean,
    bankcard character varying(20),
    createddate date,
    updateddate date
);
    DROP TABLE public.customer;
       public         heap r       postgres    false            �            1259    24699    customer_customerid_seq    SEQUENCE     �   CREATE SEQUENCE public.customer_customerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.customer_customerid_seq;
       public               postgres    false    221            
           0    0    customer_customerid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.customer_customerid_seq OWNED BY public.customer.customerid;
          public               postgres    false    222            �            1259    24700 	   inventory    TABLE     �   CREATE TABLE public.inventory (
    inventoryid integer NOT NULL,
    name character varying(255),
    address text,
    quantity integer,
    description text,
    locationid integer
);
    DROP TABLE public.inventory;
       public         heap r       postgres    false            �            1259    24705    inventory_inventoryid_seq    SEQUENCE     �   CREATE SEQUENCE public.inventory_inventoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.inventory_inventoryid_seq;
       public               postgres    false    223                       0    0    inventory_inventoryid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.inventory_inventoryid_seq OWNED BY public.inventory.inventoryid;
          public               postgres    false    224            �            1259    24706    location    TABLE     �   CREATE TABLE public.location (
    locationid integer NOT NULL,
    locationname character varying(255),
    address text,
    description text,
    phonenumber character varying(20)
);
    DROP TABLE public.location;
       public         heap r       postgres    false            �            1259    24711    location_locationid_seq    SEQUENCE     �   CREATE SEQUENCE public.location_locationid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.location_locationid_seq;
       public               postgres    false    225                       0    0    location_locationid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.location_locationid_seq OWNED BY public.location.locationid;
          public               postgres    false    226            �            1259    24712    order    TABLE     �   CREATE TABLE public."order" (
    orderid integer NOT NULL,
    totalprice numeric,
    orderdate date,
    status boolean,
    customerid integer,
    userid integer
);
    DROP TABLE public."order";
       public         heap r       postgres    false            �            1259    24723    order_orderid_seq    SEQUENCE     �   CREATE SEQUENCE public.order_orderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.order_orderid_seq;
       public               postgres    false    227                       0    0    order_orderid_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.order_orderid_seq OWNED BY public."order".orderid;
          public               postgres    false    230            �            1259    24717    orderdetail    TABLE     �   CREATE TABLE public.orderdetail (
    orderdetailid integer NOT NULL,
    quantity integer,
    userinventoryid integer,
    saleprice numeric,
    orderid integer
);
    DROP TABLE public.orderdetail;
       public         heap r       postgres    false            �            1259    24722    orderdetail_orderdetailid_seq    SEQUENCE     �   CREATE SEQUENCE public.orderdetail_orderdetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.orderdetail_orderdetailid_seq;
       public               postgres    false    228                       0    0    orderdetail_orderdetailid_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.orderdetail_orderdetailid_seq OWNED BY public.orderdetail.orderdetailid;
          public               postgres    false    229            �            1259    24737    product    TABLE     �   CREATE TABLE public.product (
    productid integer NOT NULL,
    name character varying(255),
    saleprice numeric,
    quantity integer,
    description text,
    status boolean,
    consignmentid integer
);
    DROP TABLE public.product;
       public         heap r       postgres    false            �            1259    24733    product_inventory    TABLE     �   CREATE TABLE public.product_inventory (
    productinventoryid integer NOT NULL,
    productid integer,
    inventoryid integer,
    transferdate date
);
 %   DROP TABLE public.product_inventory;
       public         heap r       postgres    false            �            1259    24736 (   product_inventory_productinventoryid_seq    SEQUENCE     �   CREATE SEQUENCE public.product_inventory_productinventoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ?   DROP SEQUENCE public.product_inventory_productinventoryid_seq;
       public               postgres    false    234                       0    0 (   product_inventory_productinventoryid_seq    SEQUENCE OWNED BY     u   ALTER SEQUENCE public.product_inventory_productinventoryid_seq OWNED BY public.product_inventory.productinventoryid;
          public               postgres    false    235            �            1259    24742    product_productid_seq    SEQUENCE     �   CREATE SEQUENCE public.product_productid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.product_productid_seq;
       public               postgres    false    236                       0    0    product_productid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.product_productid_seq OWNED BY public.product.productid;
          public               postgres    false    237            �            1259    24724    productdetail    TABLE     �   CREATE TABLE public.productdetail (
    productdetailid integer NOT NULL,
    baseprice numeric,
    status boolean,
    importdate date,
    productid integer,
    totalquantity numeric
);
 !   DROP TABLE public.productdetail;
       public         heap r       postgres    false            �            1259    24732 !   productdetail_productdetailid_seq    SEQUENCE     �   CREATE SEQUENCE public.productdetail_productdetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.productdetail_productdetailid_seq;
       public               postgres    false    231                       0    0 !   productdetail_productdetailid_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.productdetail_productdetailid_seq OWNED BY public.productdetail.productdetailid;
          public               postgres    false    233            �            1259    24729    productdetailvariantvalue    TABLE     �   CREATE TABLE public.productdetailvariantvalue (
    productdetailid integer NOT NULL,
    variantvalueid integer NOT NULL,
    id integer NOT NULL
);
 -   DROP TABLE public.productdetailvariantvalue;
       public         heap r       postgres    false            
           1259    25082     productdetailvariantvalue_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productdetailvariantvalue_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.productdetailvariantvalue_id_seq;
       public               postgres    false    232                       0    0     productdetailvariantvalue_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.productdetailvariantvalue_id_seq OWNED BY public.productdetailvariantvalue.id;
          public               postgres    false    266            �            1259    24743    purchaseorder    TABLE     �   CREATE TABLE public.purchaseorder (
    purchaseorderid integer NOT NULL,
    supplierid integer,
    quantity integer,
    note text,
    totalamount numeric,
    status boolean,
    orderdate date
);
 !   DROP TABLE public.purchaseorder;
       public         heap r       postgres    false            �            1259    24754 !   purchaseorder_purchaseorderid_seq    SEQUENCE     �   CREATE SEQUENCE public.purchaseorder_purchaseorderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.purchaseorder_purchaseorderid_seq;
       public               postgres    false    238                       0    0 !   purchaseorder_purchaseorderid_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.purchaseorder_purchaseorderid_seq OWNED BY public.purchaseorder.purchaseorderid;
          public               postgres    false    241            �            1259    24748    purchaseorderdetail    TABLE     �   CREATE TABLE public.purchaseorderdetail (
    purchaseorderdetailid integer NOT NULL,
    purchaseorderid integer,
    productid integer,
    price numeric,
    quantity integer,
    total numeric
);
 '   DROP TABLE public.purchaseorderdetail;
       public         heap r       postgres    false            �            1259    24753 -   purchaseorderdetail_purchaseorderdetailid_seq    SEQUENCE     �   CREATE SEQUENCE public.purchaseorderdetail_purchaseorderdetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 D   DROP SEQUENCE public.purchaseorderdetail_purchaseorderdetailid_seq;
       public               postgres    false    239                       0    0 -   purchaseorderdetail_purchaseorderdetailid_seq    SEQUENCE OWNED BY        ALTER SEQUENCE public.purchaseorderdetail_purchaseorderdetailid_seq OWNED BY public.purchaseorderdetail.purchaseorderdetailid;
          public               postgres    false    240            �            1259    24755    requestpurchaseorder    TABLE     u  CREATE TABLE public.requestpurchaseorder (
    requestorderid integer NOT NULL,
    supplierid integer,
    quantity integer,
    note text,
    userid integer,
    costprice numeric,
    status text,
    totalamount numeric,
    orderdate date,
    productdetailid integer,
    createdate date,
    description text,
    size text,
    color text,
    isenable boolean
);
 (   DROP TABLE public.requestpurchaseorder;
       public         heap r       postgres    false            �            1259    24760    requestorder_requestorderid_seq    SEQUENCE     �   CREATE SEQUENCE public.requestorder_requestorderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.requestorder_requestorderid_seq;
       public               postgres    false    242                       0    0    requestorder_requestorderid_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.requestorder_requestorderid_seq OWNED BY public.requestpurchaseorder.requestorderid;
          public               postgres    false    243            �            1259    24761    role    TABLE     u   CREATE TABLE public.role (
    roleid integer NOT NULL,
    rolename character varying(255),
    description text
);
    DROP TABLE public.role;
       public         heap r       postgres    false            �            1259    24766    role_roleid_seq    SEQUENCE     �   CREATE SEQUENCE public.role_roleid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.role_roleid_seq;
       public               postgres    false    244                       0    0    role_roleid_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.role_roleid_seq OWNED BY public.role.roleid;
          public               postgres    false    245            �            1259    24767    supplier    TABLE       CREATE TABLE public.supplier (
    supplierid integer NOT NULL,
    name character varying(255),
    phone character varying(20),
    email character varying(255),
    address text,
    createddate date,
    updateddate date,
    rating numeric,
    userid integer
);
    DROP TABLE public.supplier;
       public         heap r       postgres    false            �            1259    24782    supplier_supplierid_seq    SEQUENCE     �   CREATE SEQUENCE public.supplier_supplierid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.supplier_supplierid_seq;
       public               postgres    false    246                       0    0    supplier_supplierid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.supplier_supplierid_seq OWNED BY public.supplier.supplierid;
          public               postgres    false    251            �            1259    24772    supplierperformance    TABLE     6  CREATE TABLE public.supplierperformance (
    performanceid integer NOT NULL,
    supplierid integer,
    ontimedeliveryrate numeric,
    productqualityrating numeric,
    notes text,
    rulescompletionrate numeric,
    lastevaluated date,
    consignmentid integer,
    userid integer,
    status boolean
);
 '   DROP TABLE public.supplierperformance;
       public         heap r       postgres    false            �            1259    24781 %   supplierperformance_performanceid_seq    SEQUENCE     �   CREATE SEQUENCE public.supplierperformance_performanceid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.supplierperformance_performanceid_seq;
       public               postgres    false    247                       0    0 %   supplierperformance_performanceid_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.supplierperformance_performanceid_seq OWNED BY public.supplierperformance.performanceid;
          public               postgres    false    250            �            1259    24777    supplierperformancedetail    TABLE     �   CREATE TABLE public.supplierperformancedetail (
    performancedetailid integer NOT NULL,
    performanceid integer,
    status boolean,
    variantvalueid integer
);
 -   DROP TABLE public.supplierperformancedetail;
       public         heap r       postgres    false            �            1259    24780 1   supplierperformancedetail_performancedetailid_seq    SEQUENCE     �   CREATE SEQUENCE public.supplierperformancedetail_performancedetailid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 H   DROP SEQUENCE public.supplierperformancedetail_performancedetailid_seq;
       public               postgres    false    248                       0    0 1   supplierperformancedetail_performancedetailid_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public.supplierperformancedetail_performancedetailid_seq OWNED BY public.supplierperformancedetail.performancedetailid;
          public               postgres    false    249            �            1259    24783    systemconfig    TABLE     �   CREATE TABLE public.systemconfig (
    configid integer NOT NULL,
    name character varying(255),
    configvalue text,
    description text
);
     DROP TABLE public.systemconfig;
       public         heap r       postgres    false            �            1259    24788    systemconfig_configid_seq    SEQUENCE     �   CREATE SEQUENCE public.systemconfig_configid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.systemconfig_configid_seq;
       public               postgres    false    252                       0    0    systemconfig_configid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.systemconfig_configid_seq OWNED BY public.systemconfig.configid;
          public               postgres    false    253            �            1259    24789    transaction    TABLE     �   CREATE TABLE public.transaction (
    transactionid integer NOT NULL,
    money numeric,
    note text,
    date date,
    userid integer,
    orderid integer
);
    DROP TABLE public.transaction;
       public         heap r       postgres    false            �            1259    24794    transaction_transactionid_seq    SEQUENCE     �   CREATE SEQUENCE public.transaction_transactionid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.transaction_transactionid_seq;
       public               postgres    false    254                       0    0    transaction_transactionid_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.transaction_transactionid_seq OWNED BY public.transaction.transactionid;
          public               postgres    false    255                        1259    24795    transferrequest    TABLE     �   CREATE TABLE public.transferrequest (
    transferid integer NOT NULL,
    note text,
    quantity integer,
    transferdate date,
    frominventoryid integer,
    toinventoryid integer,
    userid integer,
    variantvalueid integer
);
 #   DROP TABLE public.transferrequest;
       public         heap r       postgres    false                       1259    24800    transferrequest_transferid_seq    SEQUENCE     �   CREATE SEQUENCE public.transferrequest_transferid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.transferrequest_transferid_seq;
       public               postgres    false    256                       0    0    transferrequest_transferid_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.transferrequest_transferid_seq OWNED BY public.transferrequest.transferid;
          public               postgres    false    257                       1259    24801    user_inventory    TABLE     �   CREATE TABLE public.user_inventory (
    id integer NOT NULL,
    userid integer,
    status boolean,
    inventoryid integer
);
 "   DROP TABLE public.user_inventory;
       public         heap r       postgres    false                       1259    24804    user_inventory_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_inventory_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.user_inventory_id_seq;
       public               postgres    false    258                       0    0    user_inventory_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.user_inventory_id_seq OWNED BY public.user_inventory.id;
          public               postgres    false    259                       1259    24805    users    TABLE     �   CREATE TABLE public.users (
    userid integer NOT NULL,
    username character varying(255),
    password character varying(255),
    roleid integer,
    email character varying(255),
    contactinfo text,
    createddate date,
    status boolean
);
    DROP TABLE public.users;
       public         heap r       postgres    false                       1259    24810    users_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.users_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.users_userid_seq;
       public               postgres    false    260                       0    0    users_userid_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.userid;
          public               postgres    false    261                       1259    24811    variant    TABLE     w   CREATE TABLE public.variant (
    variantid integer NOT NULL,
    name character varying(255),
    description text
);
    DROP TABLE public.variant;
       public         heap r       postgres    false            	           1259    24820    variant_variantid_seq    SEQUENCE     �   CREATE SEQUENCE public.variant_variantid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.variant_variantid_seq;
       public               postgres    false    262                       0    0    variant_variantid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.variant_variantid_seq OWNED BY public.variant.variantid;
          public               postgres    false    265                       1259    24816    variantvalue    TABLE     �   CREATE TABLE public.variantvalue (
    variantvalueid integer NOT NULL,
    value character varying(255),
    variantid integer
);
     DROP TABLE public.variantvalue;
       public         heap r       postgres    false                       1259    24819    variantvalue_variantvalueid_seq    SEQUENCE     �   CREATE SEQUENCE public.variantvalue_variantvalueid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.variantvalue_variantvalueid_seq;
       public               postgres    false    263                        0    0    variantvalue_variantvalueid_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.variantvalue_variantvalueid_seq OWNED BY public.variantvalue.variantvalueid;
          public               postgres    false    264            �           2604    24821    category categoryid    DEFAULT     z   ALTER TABLE ONLY public.category ALTER COLUMN categoryid SET DEFAULT nextval('public.category_categoryid_seq'::regclass);
 B   ALTER TABLE public.category ALTER COLUMN categoryid DROP DEFAULT;
       public               postgres    false    218    217            �           2604    24822    consignment consignmentid    DEFAULT     �   ALTER TABLE ONLY public.consignment ALTER COLUMN consignmentid SET DEFAULT nextval('public.consignment_consignmentid_seq'::regclass);
 H   ALTER TABLE public.consignment ALTER COLUMN consignmentid DROP DEFAULT;
       public               postgres    false    220    219            �           2604    24823    customer customerid    DEFAULT     z   ALTER TABLE ONLY public.customer ALTER COLUMN customerid SET DEFAULT nextval('public.customer_customerid_seq'::regclass);
 B   ALTER TABLE public.customer ALTER COLUMN customerid DROP DEFAULT;
       public               postgres    false    222    221            �           2604    24824    inventory inventoryid    DEFAULT     ~   ALTER TABLE ONLY public.inventory ALTER COLUMN inventoryid SET DEFAULT nextval('public.inventory_inventoryid_seq'::regclass);
 D   ALTER TABLE public.inventory ALTER COLUMN inventoryid DROP DEFAULT;
       public               postgres    false    224    223            �           2604    24825    location locationid    DEFAULT     z   ALTER TABLE ONLY public.location ALTER COLUMN locationid SET DEFAULT nextval('public.location_locationid_seq'::regclass);
 B   ALTER TABLE public.location ALTER COLUMN locationid DROP DEFAULT;
       public               postgres    false    226    225            �           2604    24826    order orderid    DEFAULT     p   ALTER TABLE ONLY public."order" ALTER COLUMN orderid SET DEFAULT nextval('public.order_orderid_seq'::regclass);
 >   ALTER TABLE public."order" ALTER COLUMN orderid DROP DEFAULT;
       public               postgres    false    230    227            �           2604    24827    orderdetail orderdetailid    DEFAULT     �   ALTER TABLE ONLY public.orderdetail ALTER COLUMN orderdetailid SET DEFAULT nextval('public.orderdetail_orderdetailid_seq'::regclass);
 H   ALTER TABLE public.orderdetail ALTER COLUMN orderdetailid DROP DEFAULT;
       public               postgres    false    229    228            �           2604    24844    product productid    DEFAULT     v   ALTER TABLE ONLY public.product ALTER COLUMN productid SET DEFAULT nextval('public.product_productid_seq'::regclass);
 @   ALTER TABLE public.product ALTER COLUMN productid DROP DEFAULT;
       public               postgres    false    237    236            �           2604    24829 $   product_inventory productinventoryid    DEFAULT     �   ALTER TABLE ONLY public.product_inventory ALTER COLUMN productinventoryid SET DEFAULT nextval('public.product_inventory_productinventoryid_seq'::regclass);
 S   ALTER TABLE public.product_inventory ALTER COLUMN productinventoryid DROP DEFAULT;
       public               postgres    false    235    234            �           2604    24828    productdetail productdetailid    DEFAULT     �   ALTER TABLE ONLY public.productdetail ALTER COLUMN productdetailid SET DEFAULT nextval('public.productdetail_productdetailid_seq'::regclass);
 L   ALTER TABLE public.productdetail ALTER COLUMN productdetailid DROP DEFAULT;
       public               postgres    false    233    231            �           2604    25083    productdetailvariantvalue id    DEFAULT     �   ALTER TABLE ONLY public.productdetailvariantvalue ALTER COLUMN id SET DEFAULT nextval('public.productdetailvariantvalue_id_seq'::regclass);
 K   ALTER TABLE public.productdetailvariantvalue ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    266    232            �           2604    24830    purchaseorder purchaseorderid    DEFAULT     �   ALTER TABLE ONLY public.purchaseorder ALTER COLUMN purchaseorderid SET DEFAULT nextval('public.purchaseorder_purchaseorderid_seq'::regclass);
 L   ALTER TABLE public.purchaseorder ALTER COLUMN purchaseorderid DROP DEFAULT;
       public               postgres    false    241    238            �           2604    24831 )   purchaseorderdetail purchaseorderdetailid    DEFAULT     �   ALTER TABLE ONLY public.purchaseorderdetail ALTER COLUMN purchaseorderdetailid SET DEFAULT nextval('public.purchaseorderdetail_purchaseorderdetailid_seq'::regclass);
 X   ALTER TABLE public.purchaseorderdetail ALTER COLUMN purchaseorderdetailid DROP DEFAULT;
       public               postgres    false    240    239            �           2604    24832 #   requestpurchaseorder requestorderid    DEFAULT     �   ALTER TABLE ONLY public.requestpurchaseorder ALTER COLUMN requestorderid SET DEFAULT nextval('public.requestorder_requestorderid_seq'::regclass);
 R   ALTER TABLE public.requestpurchaseorder ALTER COLUMN requestorderid DROP DEFAULT;
       public               postgres    false    243    242            �           2604    24833    role roleid    DEFAULT     j   ALTER TABLE ONLY public.role ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);
 :   ALTER TABLE public.role ALTER COLUMN roleid DROP DEFAULT;
       public               postgres    false    245    244            �           2604    24834    supplier supplierid    DEFAULT     z   ALTER TABLE ONLY public.supplier ALTER COLUMN supplierid SET DEFAULT nextval('public.supplier_supplierid_seq'::regclass);
 B   ALTER TABLE public.supplier ALTER COLUMN supplierid DROP DEFAULT;
       public               postgres    false    251    246            �           2604    24835 !   supplierperformance performanceid    DEFAULT     �   ALTER TABLE ONLY public.supplierperformance ALTER COLUMN performanceid SET DEFAULT nextval('public.supplierperformance_performanceid_seq'::regclass);
 P   ALTER TABLE public.supplierperformance ALTER COLUMN performanceid DROP DEFAULT;
       public               postgres    false    250    247            �           2604    24836 -   supplierperformancedetail performancedetailid    DEFAULT     �   ALTER TABLE ONLY public.supplierperformancedetail ALTER COLUMN performancedetailid SET DEFAULT nextval('public.supplierperformancedetail_performancedetailid_seq'::regclass);
 \   ALTER TABLE public.supplierperformancedetail ALTER COLUMN performancedetailid DROP DEFAULT;
       public               postgres    false    249    248            �           2604    24837    systemconfig configid    DEFAULT     ~   ALTER TABLE ONLY public.systemconfig ALTER COLUMN configid SET DEFAULT nextval('public.systemconfig_configid_seq'::regclass);
 D   ALTER TABLE public.systemconfig ALTER COLUMN configid DROP DEFAULT;
       public               postgres    false    253    252            �           2604    24838    transaction transactionid    DEFAULT     �   ALTER TABLE ONLY public.transaction ALTER COLUMN transactionid SET DEFAULT nextval('public.transaction_transactionid_seq'::regclass);
 H   ALTER TABLE public.transaction ALTER COLUMN transactionid DROP DEFAULT;
       public               postgres    false    255    254            �           2604    24839    transferrequest transferid    DEFAULT     �   ALTER TABLE ONLY public.transferrequest ALTER COLUMN transferid SET DEFAULT nextval('public.transferrequest_transferid_seq'::regclass);
 I   ALTER TABLE public.transferrequest ALTER COLUMN transferid DROP DEFAULT;
       public               postgres    false    257    256            �           2604    24840    user_inventory id    DEFAULT     v   ALTER TABLE ONLY public.user_inventory ALTER COLUMN id SET DEFAULT nextval('public.user_inventory_id_seq'::regclass);
 @   ALTER TABLE public.user_inventory ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    259    258            �           2604    24841    users userid    DEFAULT     l   ALTER TABLE ONLY public.users ALTER COLUMN userid SET DEFAULT nextval('public.users_userid_seq'::regclass);
 ;   ALTER TABLE public.users ALTER COLUMN userid DROP DEFAULT;
       public               postgres    false    261    260            �           2604    24842    variant variantid    DEFAULT     v   ALTER TABLE ONLY public.variant ALTER COLUMN variantid SET DEFAULT nextval('public.variant_variantid_seq'::regclass);
 @   ALTER TABLE public.variant ALTER COLUMN variantid DROP DEFAULT;
       public               postgres    false    265    262            �           2604    24843    variantvalue variantvalueid    DEFAULT     �   ALTER TABLE ONLY public.variantvalue ALTER COLUMN variantvalueid SET DEFAULT nextval('public.variantvalue_variantvalueid_seq'::regclass);
 J   ALTER TABLE public.variantvalue ALTER COLUMN variantvalueid DROP DEFAULT;
       public               postgres    false    264    263            �          0    24684    category 
   TABLE DATA           ?   COPY public.category (categoryid, name, productid) FROM stdin;
    public               postgres    false    217   u      �          0    24688    consignment 
   TABLE DATA           �   COPY public.consignment (consignmentid, sku, name, description, totalquantity, totalprice, importdate, status, supplierid, userid) FROM stdin;
    public               postgres    false    219   �      �          0    24694    customer 
   TABLE DATA           w   COPY public.customer (customerid, name, address, phone, email, status, bankcard, createddate, updateddate) FROM stdin;
    public               postgres    false    221   0      �          0    24700 	   inventory 
   TABLE DATA           b   COPY public.inventory (inventoryid, name, address, quantity, description, locationid) FROM stdin;
    public               postgres    false    223   M      �          0    24706    location 
   TABLE DATA           _   COPY public.location (locationid, locationname, address, description, phonenumber) FROM stdin;
    public               postgres    false    225   j      �          0    24712    order 
   TABLE DATA           ]   COPY public."order" (orderid, totalprice, orderdate, status, customerid, userid) FROM stdin;
    public               postgres    false    227   �      �          0    24717    orderdetail 
   TABLE DATA           c   COPY public.orderdetail (orderdetailid, quantity, userinventoryid, saleprice, orderid) FROM stdin;
    public               postgres    false    228   �      �          0    24737    product 
   TABLE DATA           k   COPY public.product (productid, name, saleprice, quantity, description, status, consignmentid) FROM stdin;
    public               postgres    false    236   �      �          0    24733    product_inventory 
   TABLE DATA           e   COPY public.product_inventory (productinventoryid, productid, inventoryid, transferdate) FROM stdin;
    public               postgres    false    234   8      �          0    24724    productdetail 
   TABLE DATA           q   COPY public.productdetail (productdetailid, baseprice, status, importdate, productid, totalquantity) FROM stdin;
    public               postgres    false    231   U      �          0    24729    productdetailvariantvalue 
   TABLE DATA           X   COPY public.productdetailvariantvalue (productdetailid, variantvalueid, id) FROM stdin;
    public               postgres    false    232   �      �          0    24743    purchaseorder 
   TABLE DATA           t   COPY public.purchaseorder (purchaseorderid, supplierid, quantity, note, totalamount, status, orderdate) FROM stdin;
    public               postgres    false    238          �          0    24748    purchaseorderdetail 
   TABLE DATA           x   COPY public.purchaseorderdetail (purchaseorderdetailid, purchaseorderid, productid, price, quantity, total) FROM stdin;
    public               postgres    false    239         �          0    24755    requestpurchaseorder 
   TABLE DATA           �   COPY public.requestpurchaseorder (requestorderid, supplierid, quantity, note, userid, costprice, status, totalamount, orderdate, productdetailid, createdate, description, size, color, isenable) FROM stdin;
    public               postgres    false    242   :      �          0    24761    role 
   TABLE DATA           =   COPY public.role (roleid, rolename, description) FROM stdin;
    public               postgres    false    244   �      �          0    24767    supplier 
   TABLE DATA           u   COPY public.supplier (supplierid, name, phone, email, address, createddate, updateddate, rating, userid) FROM stdin;
    public               postgres    false    246         �          0    24772    supplierperformance 
   TABLE DATA           �   COPY public.supplierperformance (performanceid, supplierid, ontimedeliveryrate, productqualityrating, notes, rulescompletionrate, lastevaluated, consignmentid, userid, status) FROM stdin;
    public               postgres    false    247   w      �          0    24777    supplierperformancedetail 
   TABLE DATA           o   COPY public.supplierperformancedetail (performancedetailid, performanceid, status, variantvalueid) FROM stdin;
    public               postgres    false    248   �      �          0    24783    systemconfig 
   TABLE DATA           P   COPY public.systemconfig (configid, name, configvalue, description) FROM stdin;
    public               postgres    false    252   �      �          0    24789    transaction 
   TABLE DATA           X   COPY public.transaction (transactionid, money, note, date, userid, orderid) FROM stdin;
    public               postgres    false    254   �      �          0    24795    transferrequest 
   TABLE DATA           �   COPY public.transferrequest (transferid, note, quantity, transferdate, frominventoryid, toinventoryid, userid, variantvalueid) FROM stdin;
    public               postgres    false    256   �      �          0    24801    user_inventory 
   TABLE DATA           I   COPY public.user_inventory (id, userid, status, inventoryid) FROM stdin;
    public               postgres    false    258          �          0    24805    users 
   TABLE DATA           l   COPY public.users (userid, username, password, roleid, email, contactinfo, createddate, status) FROM stdin;
    public               postgres    false    260   %       �          0    24811    variant 
   TABLE DATA           ?   COPY public.variant (variantid, name, description) FROM stdin;
    public               postgres    false    262   �       �          0    24816    variantvalue 
   TABLE DATA           H   COPY public.variantvalue (variantvalueid, value, variantid) FROM stdin;
    public               postgres    false    263   �       !           0    0    category_categoryid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.category_categoryid_seq', 1, false);
          public               postgres    false    218            "           0    0    consignment_consignmentid_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.consignment_consignmentid_seq', 1, false);
          public               postgres    false    220            #           0    0    customer_customerid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.customer_customerid_seq', 1, false);
          public               postgres    false    222            $           0    0    inventory_inventoryid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.inventory_inventoryid_seq', 1, false);
          public               postgres    false    224            %           0    0    location_locationid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.location_locationid_seq', 1, false);
          public               postgres    false    226            &           0    0    order_orderid_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.order_orderid_seq', 1, false);
          public               postgres    false    230            '           0    0    orderdetail_orderdetailid_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.orderdetail_orderdetailid_seq', 1, false);
          public               postgres    false    229            (           0    0 (   product_inventory_productinventoryid_seq    SEQUENCE SET     W   SELECT pg_catalog.setval('public.product_inventory_productinventoryid_seq', 1, false);
          public               postgres    false    235            )           0    0    product_productid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.product_productid_seq', 1, false);
          public               postgres    false    237            *           0    0 !   productdetail_productdetailid_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.productdetail_productdetailid_seq', 1, false);
          public               postgres    false    233            +           0    0     productdetailvariantvalue_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.productdetailvariantvalue_id_seq', 11, true);
          public               postgres    false    266            ,           0    0 !   purchaseorder_purchaseorderid_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.purchaseorder_purchaseorderid_seq', 1, false);
          public               postgres    false    241            -           0    0 -   purchaseorderdetail_purchaseorderdetailid_seq    SEQUENCE SET     \   SELECT pg_catalog.setval('public.purchaseorderdetail_purchaseorderdetailid_seq', 1, false);
          public               postgres    false    240            .           0    0    requestorder_requestorderid_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.requestorder_requestorderid_seq', 40, true);
          public               postgres    false    243            /           0    0    role_roleid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.role_roleid_seq', 1, false);
          public               postgres    false    245            0           0    0    supplier_supplierid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.supplier_supplierid_seq', 1, false);
          public               postgres    false    251            1           0    0 %   supplierperformance_performanceid_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.supplierperformance_performanceid_seq', 1, false);
          public               postgres    false    250            2           0    0 1   supplierperformancedetail_performancedetailid_seq    SEQUENCE SET     `   SELECT pg_catalog.setval('public.supplierperformancedetail_performancedetailid_seq', 1, false);
          public               postgres    false    249            3           0    0    systemconfig_configid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.systemconfig_configid_seq', 1, false);
          public               postgres    false    253            4           0    0    transaction_transactionid_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.transaction_transactionid_seq', 1, false);
          public               postgres    false    255            5           0    0    transferrequest_transferid_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.transferrequest_transferid_seq', 1, false);
          public               postgres    false    257            6           0    0    user_inventory_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.user_inventory_id_seq', 1, false);
          public               postgres    false    259            7           0    0    users_userid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.users_userid_seq', 1, false);
          public               postgres    false    261            8           0    0    variant_variantid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.variant_variantid_seq', 1, false);
          public               postgres    false    265            9           0    0    variantvalue_variantvalueid_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.variantvalue_variantvalueid_seq', 1, false);
          public               postgres    false    264            �           2606    24846    category category_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (categoryid);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public                 postgres    false    217            �           2606    24848    consignment consignment_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_pkey PRIMARY KEY (consignmentid);
 F   ALTER TABLE ONLY public.consignment DROP CONSTRAINT consignment_pkey;
       public                 postgres    false    219            �           2606    24850    customer customer_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customerid);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public                 postgres    false    221            �           2606    24852    inventory inventory_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (inventoryid);
 B   ALTER TABLE ONLY public.inventory DROP CONSTRAINT inventory_pkey;
       public                 postgres    false    223            �           2606    24854    location location_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (locationid);
 @   ALTER TABLE ONLY public.location DROP CONSTRAINT location_pkey;
       public                 postgres    false    225            �           2606    24858    order order_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (orderid);
 <   ALTER TABLE ONLY public."order" DROP CONSTRAINT order_pkey;
       public                 postgres    false    227            �           2606    24856    orderdetail orderdetail_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_pkey PRIMARY KEY (orderdetailid);
 F   ALTER TABLE ONLY public.orderdetail DROP CONSTRAINT orderdetail_pkey;
       public                 postgres    false    228            �           2606    24860 #   productdetailvariantvalue pdvv_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_pkey PRIMARY KEY (productdetailid, variantvalueid);
 M   ALTER TABLE ONLY public.productdetailvariantvalue DROP CONSTRAINT pdvv_pkey;
       public                 postgres    false    232    232            �           2606    24864 (   product_inventory product_inventory_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_pkey PRIMARY KEY (productinventoryid);
 R   ALTER TABLE ONLY public.product_inventory DROP CONSTRAINT product_inventory_pkey;
       public                 postgres    false    234            �           2606    24866    product product_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (productid);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public                 postgres    false    236            �           2606    24862     productdetail productdetail_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.productdetail
    ADD CONSTRAINT productdetail_pkey PRIMARY KEY (productdetailid);
 J   ALTER TABLE ONLY public.productdetail DROP CONSTRAINT productdetail_pkey;
       public                 postgres    false    231            �           2606    24870     purchaseorder purchaseorder_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.purchaseorder
    ADD CONSTRAINT purchaseorder_pkey PRIMARY KEY (purchaseorderid);
 J   ALTER TABLE ONLY public.purchaseorder DROP CONSTRAINT purchaseorder_pkey;
       public                 postgres    false    238                       2606    24868 ,   purchaseorderdetail purchaseorderdetail_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_pkey PRIMARY KEY (purchaseorderdetailid);
 V   ALTER TABLE ONLY public.purchaseorderdetail DROP CONSTRAINT purchaseorderdetail_pkey;
       public                 postgres    false    239                       2606    24872 &   requestpurchaseorder requestorder_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.requestpurchaseorder
    ADD CONSTRAINT requestorder_pkey PRIMARY KEY (requestorderid);
 P   ALTER TABLE ONLY public.requestpurchaseorder DROP CONSTRAINT requestorder_pkey;
       public                 postgres    false    242                       2606    24874    role role_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public                 postgres    false    244                       2606    24880    supplier supplier_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (supplierid);
 @   ALTER TABLE ONLY public.supplier DROP CONSTRAINT supplier_pkey;
       public                 postgres    false    246            	           2606    24878 ,   supplierperformance supplierperformance_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_pkey PRIMARY KEY (performanceid);
 V   ALTER TABLE ONLY public.supplierperformance DROP CONSTRAINT supplierperformance_pkey;
       public                 postgres    false    247                       2606    24876 8   supplierperformancedetail supplierperformancedetail_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_pkey PRIMARY KEY (performancedetailid);
 b   ALTER TABLE ONLY public.supplierperformancedetail DROP CONSTRAINT supplierperformancedetail_pkey;
       public                 postgres    false    248                       2606    24882    systemconfig systemconfig_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.systemconfig
    ADD CONSTRAINT systemconfig_pkey PRIMARY KEY (configid);
 H   ALTER TABLE ONLY public.systemconfig DROP CONSTRAINT systemconfig_pkey;
       public                 postgres    false    252                       2606    24884    transaction transaction_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (transactionid);
 F   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_pkey;
       public                 postgres    false    254                       2606    24886 $   transferrequest transferrequest_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_pkey PRIMARY KEY (transferid);
 N   ALTER TABLE ONLY public.transferrequest DROP CONSTRAINT transferrequest_pkey;
       public                 postgres    false    256                       2606    24888 "   user_inventory user_inventory_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.user_inventory DROP CONSTRAINT user_inventory_pkey;
       public                 postgres    false    258                       2606    24890    users users_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public                 postgres    false    260                       2606    24894    variant variant_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.variant
    ADD CONSTRAINT variant_pkey PRIMARY KEY (variantid);
 >   ALTER TABLE ONLY public.variant DROP CONSTRAINT variant_pkey;
       public                 postgres    false    262                       2606    24892    variantvalue variantvalue_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.variantvalue
    ADD CONSTRAINT variantvalue_pkey PRIMARY KEY (variantvalueid);
 H   ALTER TABLE ONLY public.variantvalue DROP CONSTRAINT variantvalue_pkey;
       public                 postgres    false    263                       2606    24895     category category_productid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);
 J   ALTER TABLE ONLY public.category DROP CONSTRAINT category_productid_fkey;
       public               postgres    false    217    4861    236                       2606    24900 '   consignment consignment_supplierid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);
 Q   ALTER TABLE ONLY public.consignment DROP CONSTRAINT consignment_supplierid_fkey;
       public               postgres    false    4871    219    246                       2606    24905 #   consignment consignment_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.consignment
    ADD CONSTRAINT consignment_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 M   ALTER TABLE ONLY public.consignment DROP CONSTRAINT consignment_userid_fkey;
       public               postgres    false    219    260    4885                       2606    24910 #   inventory inventory_locationid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_locationid_fkey FOREIGN KEY (locationid) REFERENCES public.location(locationid);
 M   ALTER TABLE ONLY public.inventory DROP CONSTRAINT inventory_locationid_fkey;
       public               postgres    false    223    4849    225                       2606    24925    order order_customerid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_customerid_fkey FOREIGN KEY (customerid) REFERENCES public.customer(customerid);
 G   ALTER TABLE ONLY public."order" DROP CONSTRAINT order_customerid_fkey;
       public               postgres    false    227    4845    221                       2606    24930    order order_userid_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 C   ALTER TABLE ONLY public."order" DROP CONSTRAINT order_userid_fkey;
       public               postgres    false    260    4885    227                        2606    24915 $   orderdetail orderdetail_orderid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_orderid_fkey FOREIGN KEY (orderid) REFERENCES public."order"(orderid);
 N   ALTER TABLE ONLY public.orderdetail DROP CONSTRAINT orderdetail_orderid_fkey;
       public               postgres    false    228    4851    227            !           2606    24920 ,   orderdetail orderdetail_userinventoryid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.orderdetail
    ADD CONSTRAINT orderdetail_userinventoryid_fkey FOREIGN KEY (userinventoryid) REFERENCES public.user_inventory(id);
 V   ALTER TABLE ONLY public.orderdetail DROP CONSTRAINT orderdetail_userinventoryid_fkey;
       public               postgres    false    228    4883    258            #           2606    24935 1   productdetailvariantvalue pdvv_productdetail_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_productdetail_fkey FOREIGN KEY (productdetailid) REFERENCES public.productdetail(productdetailid) ON DELETE CASCADE;
 [   ALTER TABLE ONLY public.productdetailvariantvalue DROP CONSTRAINT pdvv_productdetail_fkey;
       public               postgres    false    231    4855    232            $           2606    24940 0   productdetailvariantvalue pdvv_variantvalue_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.productdetailvariantvalue
    ADD CONSTRAINT pdvv_variantvalue_fkey FOREIGN KEY (variantvalueid) REFERENCES public.variantvalue(variantvalueid);
 Z   ALTER TABLE ONLY public.productdetailvariantvalue DROP CONSTRAINT pdvv_variantvalue_fkey;
       public               postgres    false    232    4889    263            '           2606    24950 "   product product_consignmentid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_consignmentid_fkey FOREIGN KEY (consignmentid) REFERENCES public.consignment(consignmentid);
 L   ALTER TABLE ONLY public.product DROP CONSTRAINT product_consignmentid_fkey;
       public               postgres    false    236    4843    219            %           2606    24955 4   product_inventory product_inventory_inventoryid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_inventoryid_fkey FOREIGN KEY (inventoryid) REFERENCES public.inventory(inventoryid);
 ^   ALTER TABLE ONLY public.product_inventory DROP CONSTRAINT product_inventory_inventoryid_fkey;
       public               postgres    false    234    4847    223            &           2606    24960 2   product_inventory product_inventory_productid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_inventory
    ADD CONSTRAINT product_inventory_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);
 \   ALTER TABLE ONLY public.product_inventory DROP CONSTRAINT product_inventory_productid_fkey;
       public               postgres    false    4861    236    234            "           2606    24945 *   productdetail productdetail_productid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.productdetail
    ADD CONSTRAINT productdetail_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);
 T   ALTER TABLE ONLY public.productdetail DROP CONSTRAINT productdetail_productid_fkey;
       public               postgres    false    236    231    4861            (           2606    24975 +   purchaseorder purchaseorder_supplierid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.purchaseorder
    ADD CONSTRAINT purchaseorder_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);
 U   ALTER TABLE ONLY public.purchaseorder DROP CONSTRAINT purchaseorder_supplierid_fkey;
       public               postgres    false    238    246    4871            )           2606    24965 6   purchaseorderdetail purchaseorderdetail_productid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);
 `   ALTER TABLE ONLY public.purchaseorderdetail DROP CONSTRAINT purchaseorderdetail_productid_fkey;
       public               postgres    false    239    236    4861            *           2606    24970 <   purchaseorderdetail purchaseorderdetail_purchaseorderid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.purchaseorderdetail
    ADD CONSTRAINT purchaseorderdetail_purchaseorderid_fkey FOREIGN KEY (purchaseorderid) REFERENCES public.purchaseorder(purchaseorderid);
 f   ALTER TABLE ONLY public.purchaseorderdetail DROP CONSTRAINT purchaseorderdetail_purchaseorderid_fkey;
       public               postgres    false    239    238    4863            +           2606    24980 6   requestpurchaseorder requestorder_productdetailid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.requestpurchaseorder
    ADD CONSTRAINT requestorder_productdetailid_fkey FOREIGN KEY (productdetailid) REFERENCES public.productdetail(productdetailid);
 `   ALTER TABLE ONLY public.requestpurchaseorder DROP CONSTRAINT requestorder_productdetailid_fkey;
       public               postgres    false    231    4855    242            ,           2606    24985 1   requestpurchaseorder requestorder_supplierid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.requestpurchaseorder
    ADD CONSTRAINT requestorder_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);
 [   ALTER TABLE ONLY public.requestpurchaseorder DROP CONSTRAINT requestorder_supplierid_fkey;
       public               postgres    false    242    246    4871            -           2606    24990 -   requestpurchaseorder requestorder_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.requestpurchaseorder
    ADD CONSTRAINT requestorder_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 W   ALTER TABLE ONLY public.requestpurchaseorder DROP CONSTRAINT requestorder_userid_fkey;
       public               postgres    false    4885    260    242            .           2606    25020    supplier supplier_userid_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 G   ALTER TABLE ONLY public.supplier DROP CONSTRAINT supplier_userid_fkey;
       public               postgres    false    246    4885    260            /           2606    25005 :   supplierperformance supplierperformance_consignmentid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_consignmentid_fkey FOREIGN KEY (consignmentid) REFERENCES public.consignment(consignmentid);
 d   ALTER TABLE ONLY public.supplierperformance DROP CONSTRAINT supplierperformance_consignmentid_fkey;
       public               postgres    false    4843    219    247            0           2606    25010 7   supplierperformance supplierperformance_supplierid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_supplierid_fkey FOREIGN KEY (supplierid) REFERENCES public.supplier(supplierid);
 a   ALTER TABLE ONLY public.supplierperformance DROP CONSTRAINT supplierperformance_supplierid_fkey;
       public               postgres    false    246    247    4871            1           2606    25015 3   supplierperformance supplierperformance_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.supplierperformance
    ADD CONSTRAINT supplierperformance_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 ]   ALTER TABLE ONLY public.supplierperformance DROP CONSTRAINT supplierperformance_userid_fkey;
       public               postgres    false    247    260    4885            2           2606    24995 F   supplierperformancedetail supplierperformancedetail_performanceid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_performanceid_fkey FOREIGN KEY (performanceid) REFERENCES public.supplierperformance(performanceid);
 p   ALTER TABLE ONLY public.supplierperformancedetail DROP CONSTRAINT supplierperformancedetail_performanceid_fkey;
       public               postgres    false    4873    247    248            3           2606    25000 G   supplierperformancedetail supplierperformancedetail_variantvalueid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.supplierperformancedetail
    ADD CONSTRAINT supplierperformancedetail_variantvalueid_fkey FOREIGN KEY (variantvalueid) REFERENCES public.variantvalue(variantvalueid);
 q   ALTER TABLE ONLY public.supplierperformancedetail DROP CONSTRAINT supplierperformancedetail_variantvalueid_fkey;
       public               postgres    false    4889    263    248            4           2606    25025 $   transaction transaction_orderid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_orderid_fkey FOREIGN KEY (orderid) REFERENCES public."order"(orderid);
 N   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_orderid_fkey;
       public               postgres    false    227    254    4851            5           2606    25030 #   transaction transaction_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 M   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_userid_fkey;
       public               postgres    false    254    260    4885            6           2606    25035 4   transferrequest transferrequest_frominventoryid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_frominventoryid_fkey FOREIGN KEY (frominventoryid) REFERENCES public.inventory(inventoryid);
 ^   ALTER TABLE ONLY public.transferrequest DROP CONSTRAINT transferrequest_frominventoryid_fkey;
       public               postgres    false    4847    256    223            7           2606    25040 2   transferrequest transferrequest_toinventoryid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_toinventoryid_fkey FOREIGN KEY (toinventoryid) REFERENCES public.inventory(inventoryid);
 \   ALTER TABLE ONLY public.transferrequest DROP CONSTRAINT transferrequest_toinventoryid_fkey;
       public               postgres    false    256    4847    223            8           2606    25045 +   transferrequest transferrequest_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 U   ALTER TABLE ONLY public.transferrequest DROP CONSTRAINT transferrequest_userid_fkey;
       public               postgres    false    256    4885    260            9           2606    25050 3   transferrequest transferrequest_variantvalueid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transferrequest
    ADD CONSTRAINT transferrequest_variantvalueid_fkey FOREIGN KEY (variantvalueid) REFERENCES public.variantvalue(variantvalueid);
 ]   ALTER TABLE ONLY public.transferrequest DROP CONSTRAINT transferrequest_variantvalueid_fkey;
       public               postgres    false    4889    256    263            :           2606    25055 .   user_inventory user_inventory_inventoryid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_inventoryid_fkey FOREIGN KEY (inventoryid) REFERENCES public.inventory(inventoryid);
 X   ALTER TABLE ONLY public.user_inventory DROP CONSTRAINT user_inventory_inventoryid_fkey;
       public               postgres    false    4847    223    258            ;           2606    25060 )   user_inventory user_inventory_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_inventory
    ADD CONSTRAINT user_inventory_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 S   ALTER TABLE ONLY public.user_inventory DROP CONSTRAINT user_inventory_userid_fkey;
       public               postgres    false    258    4885    260            <           2606    25065    users users_roleid_fkey    FK CONSTRAINT     x   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_roleid_fkey FOREIGN KEY (roleid) REFERENCES public.role(roleid);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_roleid_fkey;
       public               postgres    false    244    260    4869            =           2606    25070 (   variantvalue variantvalue_variantid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.variantvalue
    ADD CONSTRAINT variantvalue_variantid_fkey FOREIGN KEY (variantid) REFERENCES public.variant(variantid);
 R   ALTER TABLE ONLY public.variantvalue DROP CONSTRAINT variantvalue_variantid_fkey;
       public               postgres    false    263    262    4887            �      x������ � �      �   �   x�3�LLI�5��50�5��9�E!����t���S2S�9s���w/OTH+�?�=9W!/#����R�����f��qsZ�����)�d΂Լ�̼tN#N#.#N?ov�ef�bؘ�m����N�9�b���� ��R�      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   g   x�3�<�0_���B��L�Ĕ̔�bN#c �45�"W�i�e�,��ih�a��#$S�i�e-�(�Sp��`
Vol��A2�!
6�� ��I5��=... ��=�      �      x������ � �      �   N   x�uͱ�0C���%��� ���/H��/�c��n�n��ΝGA&4w�P�,���;��5�� ��$�      �   =   x����@B�3�G�������f�52�U�ZKC�GY莭������3%a�� D�      �      x������ � �      �      x������ � �      �   i  x���An�0E��� �=�,�o8*OR�Zc��T��4�c�����f���o<�L
����y��=�+�@@�
�ʂ���f�]��MmQs���wF�����c�����ntݏ��&R��-��[�u�o�]?�I��W6�x�Z�2�*�=�c�-ڴ����3���bNٲ9\-�|��K/���ݟ\�Aޔ����"_��� �ևX}�i}��~Z?���r<����{D�\_/�3׷ �����/x���b~��_ ���b~��_ ���b~1���_��b�8s���zm��a�ь��	w�s4����E�@>I���!�BB��!!����H:G8$�C�$߯�Z�      �   C   x�3�tL����L�
��yi��
ŕ�%��\F��%�iiR(]��
�3��M�KLO-���r1z\\\ N��      �   a   x�3����N�40426153����s3s���s9���9��Lu�t-��1~��\F��)�)�Ŝ��f�&�F�Pw$c�c����� �<!N      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   \   x�3��K/�L�SH��P()M��442"NcN�H�!=713G/9?�����������g	�gJb^�BJi�BI>�I@� �>L�b���� ��.C      �   +   x�3�L���/��
�i
E�)��%\F�řU�`Y8F��� �	$      �   '   x�3���4�2���ƜI9����\&�E�)@:F��� i�%     