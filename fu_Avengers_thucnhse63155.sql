USE [master]
GO
ALTER DATABASE [fu_Avengers] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [fu_Avengers] SET ANSI_NULLS OFF
GO
ALTER DATABASE [fu_Avengers] SET ANSI_PADDING OFF
GO
ALTER DATABASE [fu_Avengers] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [fu_Avengers] SET ARITHABORT OFF
GO
ALTER DATABASE [fu_Avengers] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [fu_Avengers] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [fu_Avengers] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [fu_Avengers] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [fu_Avengers] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [fu_Avengers] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [fu_Avengers] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [fu_Avengers] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [fu_Avengers] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [fu_Avengers] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [fu_Avengers] SET  DISABLE_BROKER
GO
ALTER DATABASE [fu_Avengers] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [fu_Avengers] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [fu_Avengers] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [fu_Avengers] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [fu_Avengers] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [fu_Avengers] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [fu_Avengers] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [fu_Avengers] SET  READ_WRITE
GO
ALTER DATABASE [fu_Avengers] SET RECOVERY SIMPLE
GO
ALTER DATABASE [fu_Avengers] SET  MULTI_USER
GO
ALTER DATABASE [fu_Avengers] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [fu_Avengers] SET DB_CHAINING OFF
GO
USE [fu_Avengers]
GO
/****** Object:  Table [dbo].[Missions]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Missions](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Code] [varchar](10) NOT NULL,
	[Title] [nvarchar](30) NULL,
	[Location] [nvarchar](50) NULL,
	[Status] [nvarchar](50) NULL,
	[StartDate] [date] NULL,
	[EndDate] [date] NULL,
	[Description] [nvarchar](max) NULL,
 CONSTRAINT [PK_Missions] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [IX_Missions] UNIQUE NONCLUSTERED 
(
	[Code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Missions] ON
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (1, N'M01', N'NewYork''s Safe', N'New York', N'Failed', CAST(0xB93D0B00 AS Date), CAST(0xDE3D0B00 AS Date), N'Kill all the the alien monster and save the citizens')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (2, N'M02', N'Wakanda forever v2', N'Wakanda', N'Finished', CAST(0xD33E0B00 AS Date), CAST(0x0F3F0B00 AS Date), N'Protect Wakanda safe')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (3, N'M03', N'Terror attacks', N'Brazil', N'Finished', CAST(0x213F0B00 AS Date), CAST(0x793E0B00 AS Date), N'Prevent the alien')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (23, N'M04', N'Protect', N'Russia', N'Finished', CAST(0x213F0B00 AS Date), CAST(0x703E0B00 AS Date), N'Protect')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (24, N'M05', N'Attack', N'VietNam', N'Finished', CAST(0x213F0B00 AS Date), CAST(0x793E0B00 AS Date), N'Attack')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (25, N'M06', N'Wakanda forever', N'Wakanda', N'Finished', CAST(0xF4390B00 AS Date), CAST(0x003A0B00 AS Date), N'Kill all the monster and protect Wakanda')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (26, N'M07', N'Korea protect', N'Korea', N'Failed', CAST(0xEA390B00 AS Date), CAST(0xBE3A0B00 AS Date), N'Protect Korea')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (27, N'M08', N'Protect the presidentt', N'New yorkk', N'Finished', CAST(0x2E3C0B00 AS Date), CAST(0x783E0B00 AS Date), N'Protect the president ttt')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (43, N'M09', N'VietNam', N'VietNam', N'Finished', CAST(0x2E3C0B00 AS Date), CAST(0x783E0B00 AS Date), N'Protect VietNam')
INSERT [dbo].[Missions] ([ID], [Code], [Title], [Location], [Status], [StartDate], [EndDate], [Description]) VALUES (49, N'testmiss', N'testmiss', N'testmiss', N'Failed', CAST(0x753E0B00 AS Date), CAST(0x7D3E0B00 AS Date), N'')
SET IDENTITY_INSERT [dbo].[Missions] OFF
/****** Object:  Table [dbo].[Materials]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Materials](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [varchar](max) NULL,
 CONSTRAINT [PK_Materials] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Materials] ON
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (1, N'Proto-Adamantium', N'It has never been recreated and is the absolutely most indestructible item in all of existence')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (2, N'Adamantium A', N'It has never been recreated and is the absolutely most indestructible item in all of existence')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (3, N'Secondary Adamantium', N'This is much easier to work with, making it much more cost effective though at the expense of its strength. ')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (4, N'Adamantium B', N'Adamantium has thirteen allotropes, all of which are "unstable, and short-lived, but virulently poisonous')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (5, N'Carbonadium', N'Carbonadium is a resilient, unstable metal that is vastly stronger than steel, but more flexible than Adamantium. ')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (6, N'Vibranium A', N'Vibranium is a rare metallic substance of extraterrestrial origin')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (7, N'Vibranium B', N'Vibranium is a rare metallic substance of extraterrestrial origin')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (8, N'Iron Man metallic alloys', N'Titanium-Gold Alloy is a special metal alloy used by Tony Stark as the base armor for his Iron Man Armors. ')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (9, N'Uru', N' It resembles stone but it also seems to have metallic properties. It seems able to store most energies, particularly magic.')
INSERT [dbo].[Materials] ([ID], [Name], [Description]) VALUES (10, N'Adamantium Allotropes', N'Adamantium has thirteen allotropes, all of which are "unstable, and short-lived, but virulently poisonous')
SET IDENTITY_INSERT [dbo].[Materials] OFF
/****** Object:  Table [dbo].[Weapons]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Weapons](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Power] [int] NULL,
 CONSTRAINT [PK_Weapons] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Weapons] ON
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (1, N'Repulsors', N'The Mark XI contains the standard and basic technology for the Repulsors and uses the Repulsion Mark I technology in it''s Repulsors. It''s Repulsors are powerful, just like the standards of a basic Repulsor. They are used for Flight Stabilization, and is commonly used a weapon', 90)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (2, N'Unibeammm', N'The Mark XI has a standard circular-shaped Unibeam powered by the new Vibranium Arc Reactor Mark II.', 80)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (5, N'Pulse Barrage', N'Pulse Barrage is one of Iron Man''s standard long range attack', 90)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (6, N'Energy Shield', N'nergy shielding that can protect the user from harm', 70)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (7, N'Pulse Bolts', N'Extremely powerful plasma discharges that propagate in strength over distance', 95)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (8, N'Energy Blade', N'Based on the same design Tony Stark used to build Captain America''s energy shield, this laser sword', 80)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (9, N'Tri-beam', N'This version of the Unibeam runs on direct power from the Arc Reactor', 70)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (10, N'Multi-beam', N'the Multi-beam can fire multiple energies at the same time', 95)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (11, N'Pentabeam', N'The Pentabeam has microwave lensing that allows for directed beams of high joule electrons, protons, acoustic energy, and neutrons.', 98)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (12, N'Omnibeam', N' Omnibeam can generate heats at 25232 degrees Fahrenheit, extremely powerful lights causing irreversible blindness in the enemy', 100)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (31, N'fds', N'  gs', 5)
INSERT [dbo].[Weapons] ([ID], [Name], [Description], [Power]) VALUES (32, N'testweapon', N'testweapon', 1)
SET IDENTITY_INSERT [dbo].[Weapons] OFF
/****** Object:  Table [dbo].[Users]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](30) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[LastName] [nvarchar](30) NULL,
	[FirstName] [nvarchar](30) NULL,
	[Email] [nvarchar](70) NULL,
	[Role] [varchar](10) NULL,
	[Image] [nvarchar](max) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UniqueUsername] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (4, N'captain', N'1', N'Rogerfasgasgsa', N'Steve', N'captain@avenger.com', N'user', N'captainAmerica.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (6, N'jarvis', N'1', N'', N'Jarvis', N'jarvis@avenger.com', N'admin', N'jarvis.png')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (7, N'ironman', N'1', N'Tony', N'Stark', N'starktony@avenger.com', N'user', N'ironman.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (8, N'thor', N'1', N'Odinson', N'Thor', N'rabbit@avenger.com', N'user', N'thor.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (9, N'drstrange', N'1', N'Stephen', N'Vincent Strange', N'dtstrange@avenger.com', N'user', N'drStrange.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (10, N'loki', N'1', N'Laufeyson', N'Loki', N'loki@avenger.com', N'user', N'loki.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (11, N'hulk', N'1', N'Bruce', N'Banner', N'hulk@avenger.com', N'user', N'hulk.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (36, N'spiderman', N'1', N'Parker', N'Peter', N'peterparker@avenger.com', N'user', N'spider-man.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (40, N'blackwidow', N'1', N'Romanoff', N'Natasha ', N'blackwidow@avenger.com', N'user', N'black-widow.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (42, N'bucky', N'1', N'Barnes ', N'Bucky', N'bucky@avenger.com', N'user', N'bucky.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (43, N'drax', N'1', N'Douglas', N'Arthur', N'drax@avenger.com', N'user', N'drax.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (44, N'falcon', N'1', N'Samuel Thomas', N'Sam Wilson', N'falcon@avenger.com', N'user', N'falcon.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (46, N'scarlet', N'1', N'Maximoff', N'Wanda ', N'scarletwitch@avenger.com', N'user', N'scarlet.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (47, N'rocket', N'1', N'Raccoon', N'Rocket', N'rocket@avenget.com', N'user', N'rocket-babygroot.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (49, N'groot', N'1', NULL, N'Groot', N'groot@avenger.com', N'user', N'groot.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (50, N'starlord', N'1', N'Quill', N'Peter ', N'starlord@avenger.com', N'user', N'starlord.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (52, N'vision', N'1', NULL, N'Vision', N'vision@avenger.com', N'user', N'vision.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (54, N'warmachine', N'1', N'James Rupert', N'Rhodey Rhodes', N'warmachine@avenger.com', N'user', N'warMachine.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (56, N'wong', N'1', N'', N'Wong', N'wong@avenger.com', N'user', N'wong-benedict.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (58, N'okoye', N'1', N'', N'Okoye', N'okoye@avenger.com', N'user', N'okoye.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (59, N'quicksilver', N'1', N'Maximoff', N'Pietro', N'quicksilver@avenger.com', N'user', N'quick-silver.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (60, N'hawkeye', N'1', N'Clinton Francisn', N'Clint Bartonn', N'hawkeye@avenger.comn', N'user', N'hawkeye.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (67, N'captainmarvel', N'1', N'Danvers', N'Carol', N'captainmarvel@avenger.com', N'user', N'captainmarvel.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (81, N'thucnh', N'1', N'Nguyen Huy', N'Thuc', N'thucnh@avenger.com', N'admin', N'thucnh.jpg')
INSERT [dbo].[Users] ([ID], [Username], [Password], [LastName], [FirstName], [Email], [Role], [Image]) VALUES (83, N'babygroot', N'1', N'Baby', N'Groot', N'babygroot@avenger.com', N'user', N'rocket-babygroot.jpg')
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Table [dbo].[Armors]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Armors](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Code] [char](10) NOT NULL,
	[Name] [varchar](50) NULL,
	[MaterialID] [int] NULL,
	[Available] [bit] NULL,
	[Description] [varchar](max) NULL,
	[Image] [nvarchar](max) NULL,
 CONSTRAINT [PK_Armors] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [IX_Armors] UNIQUE NONCLUSTERED 
(
	[Code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Armors] ON
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (1, N'A01       ', N'Mark VI', 1, 0, N'Its overall color design uses red, gold and silver plates.', N'markVI.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (2, N'A02       ', N'Mark XLVI', 5, 1, N'The Mark 46 has a different and unique design to its predecessors. It has a trapezoid-shaped indent design stationed around the circular chest RT.', N'markXLVI.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (3, N'A03       ', N'Mark IX', 2, 1, N'The Mark 9 (Mark IX) is a Fully-Loaded Advanced Flight Prototype.', N'markIX.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (19, N'A05       ', N'Hulkbuster', 8, 1, N'The armor is an example of the Modular Armor in action, with numerous external add-ons to give it the strength and durability to combat the Hulk.', N'hulkbuster.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (50, N'A06       ', N'Mark IV', 2, 1, N'The Mark IV include redesigns of the armor platings, and the change of the new chest piece with the new Palladium Arc Reactor Mark III.', N'markIV.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (51, N'A07       ', N'Mark VII', 3, 1, N'The armor has a unique feature that involves forming itself into a large pod, and when opened, had mechanical arms, that could extend and reach onto Tony''s arms.', N'markVII.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (52, N'A08       ', N'Mark VIII', 4, 1, N'The armor equipped with a vast variety of weapons, and is more versatile and maneuverable than its predecessor.', N'markVIII.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (53, N'A09       ', N'Mark XL', 2, 1, N'The armor was built for hyper velocity traveling, and specializes in high speed flights.', N'markXL.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (54, N'A10       ', N'Mark XVII', 3, 1, N'The Mark 17 (Mark XVII), famously known by its name as the "Heartbreaker".', N'markXVII.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (55, N'A11       ', N'Mark XXXIII', 2, 1, N'Armor was designed for energy amplification and redirection, and thus has a distinctive body shape, being angular and polygonal.', N'markXXXIII.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (56, N'A12       ', N'Mark XXXV', 6, 1, N'The Mark 35 has a bright red colored armor, together with some dark steel silver platings on some areas.', N'markXXXV.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (57, N'A13       ', N'Mark XLII', 8, 1, N'Known by its code name "Extremis" or the “Prodigal Son” is an Autonomous Prehensile Propulsion Suit Prototype was the forty second armor.', N'markXLII.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (58, N'A14       ', N'Mark V', 9, 1, N'The suit was built as a base for experimenting on newer and more advanced transport features for Tony''s suits.', N'markV.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (59, N'A15       ', N'Mark III', 7, 1, N'Equipped with a variety of incredible enhancements and upgrades.', N'markIII.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (60, N'A16       ', N'Mark XXV', 10, 1, N'The suit earned it''s name the "Striker", because of it''s powerful jackhammer like hands that can pulverize concrete. ', N'markXXV.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (62, N'A17       ', N'MarkXLI', 7, 1, N'The Mark 41 has black and silver plates which cover the internal systems of the armor as well as serve as the strong.', N'deault-armorIMG.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (86, N'A18       ', N'Iron Spider Armor', 5, 1, N'Iron Spider ended up in the possession of Ceres She changed the suit to black and yellow, added a waldo, and completed numerous unrevealed upgrades.', N'spiderman-armor-suit.jpg')
INSERT [dbo].[Armors] ([ID], [Code], [Name], [MaterialID], [Available], [Description], [Image]) VALUES (96, N'Mark50    ', N'Mark50', 1, 1, N'saga', N'24072018164027icon.png')
SET IDENTITY_INSERT [dbo].[Armors] OFF
/****** Object:  Table [dbo].[UserMission]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserMission](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[MissionID] [int] NOT NULL,
 CONSTRAINT [PK_UserArmor] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [IX_UserMission] UNIQUE NONCLUSTERED 
(
	[MissionID] ASC,
	[UserID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[UserMission] ON
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (141, 4, 1)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (142, 7, 1)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (143, 8, 1)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (180, 8, 2)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (167, 9, 2)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (168, 10, 2)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (169, 11, 2)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (211, 8, 3)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (156, 44, 3)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (157, 46, 3)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (158, 47, 3)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (212, 8, 24)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (159, 49, 24)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (160, 50, 24)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (161, 52, 24)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (162, 54, 24)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (163, 56, 25)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (164, 58, 25)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (165, 59, 25)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (166, 60, 25)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (150, 40, 26)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (151, 42, 26)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (152, 43, 26)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (181, 8, 27)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (147, 59, 27)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (148, 60, 27)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (149, 67, 27)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (216, 4, 43)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (217, 7, 43)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (218, 8, 43)
INSERT [dbo].[UserMission] ([ID], [UserID], [MissionID]) VALUES (219, 83, 49)
SET IDENTITY_INSERT [dbo].[UserMission] OFF
/****** Object:  Table [dbo].[ArmorWeapon]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ArmorWeapon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[WeaponID] [int] NOT NULL,
	[ArmorID] [int] NOT NULL,
 CONSTRAINT [PK_ArmorWeapon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [IX_ArmorWeapon] UNIQUE NONCLUSTERED 
(
	[ArmorID] ASC,
	[WeaponID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ArmorWeapon] ON
INSERT [dbo].[ArmorWeapon] ([ID], [WeaponID], [ArmorID]) VALUES (422, 1, 60)
INSERT [dbo].[ArmorWeapon] ([ID], [WeaponID], [ArmorID]) VALUES (423, 2, 60)
INSERT [dbo].[ArmorWeapon] ([ID], [WeaponID], [ArmorID]) VALUES (424, 5, 60)
INSERT [dbo].[ArmorWeapon] ([ID], [WeaponID], [ArmorID]) VALUES (433, 1, 96)
INSERT [dbo].[ArmorWeapon] ([ID], [WeaponID], [ArmorID]) VALUES (434, 2, 96)
SET IDENTITY_INSERT [dbo].[ArmorWeapon] OFF
/****** Object:  Table [dbo].[ArmorUse]    Script Date: 12/16/2018 14:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ArmorUse](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NULL,
	[ArmorID] [int] NULL,
	[StartDate] [date] NULL,
	[EndDate] [date] NULL,
	[Status] [varchar](50) NULL,
	[WeaponRequest] [varchar](max) NULL,
 CONSTRAINT [PK_ArmorUseHistory] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ArmorUse] ON
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (16, NULL, 60, CAST(0x813E0B00 AS Date), NULL, N'Allowed', N'1-2-5-')
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (17, NULL, 62, CAST(0x813E0B00 AS Date), NULL, N'Allowed', N'')
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (18, NULL, NULL, CAST(0x813E0B00 AS Date), NULL, N'Allowed', N'1-2-5-6-')
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (19, NULL, NULL, NULL, NULL, N'Waiting', N'1-2-5-')
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (20, 8, 86, NULL, NULL, N'Refused', N'')
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (21, 7, 86, CAST(0x823E0B00 AS Date), CAST(0x823E0B00 AS Date), N'Allowed', N'')
INSERT [dbo].[ArmorUse] ([ID], [UserID], [ArmorID], [StartDate], [EndDate], [Status], [WeaponRequest]) VALUES (22, 7, 1, CAST(0x823E0B00 AS Date), NULL, N'Allowed', N'')
SET IDENTITY_INSERT [dbo].[ArmorUse] OFF
/****** Object:  ForeignKey [FK_Armors_Materials]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[Armors]  WITH CHECK ADD  CONSTRAINT [FK_Armors_Materials] FOREIGN KEY([MaterialID])
REFERENCES [dbo].[Materials] ([ID])
GO
ALTER TABLE [dbo].[Armors] CHECK CONSTRAINT [FK_Armors_Materials]
GO
/****** Object:  ForeignKey [FK_UserMission_Missions]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[UserMission]  WITH CHECK ADD  CONSTRAINT [FK_UserMission_Missions] FOREIGN KEY([MissionID])
REFERENCES [dbo].[Missions] ([ID])
GO
ALTER TABLE [dbo].[UserMission] CHECK CONSTRAINT [FK_UserMission_Missions]
GO
/****** Object:  ForeignKey [FK_UserMission_Users1]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[UserMission]  WITH CHECK ADD  CONSTRAINT [FK_UserMission_Users1] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[UserMission] CHECK CONSTRAINT [FK_UserMission_Users1]
GO
/****** Object:  ForeignKey [FK_ArmorWeapon_Armors]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[ArmorWeapon]  WITH CHECK ADD  CONSTRAINT [FK_ArmorWeapon_Armors] FOREIGN KEY([ArmorID])
REFERENCES [dbo].[Armors] ([ID])
GO
ALTER TABLE [dbo].[ArmorWeapon] CHECK CONSTRAINT [FK_ArmorWeapon_Armors]
GO
/****** Object:  ForeignKey [FK_ArmorWeapon_Weapons]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[ArmorWeapon]  WITH CHECK ADD  CONSTRAINT [FK_ArmorWeapon_Weapons] FOREIGN KEY([WeaponID])
REFERENCES [dbo].[Weapons] ([ID])
GO
ALTER TABLE [dbo].[ArmorWeapon] CHECK CONSTRAINT [FK_ArmorWeapon_Weapons]
GO
/****** Object:  ForeignKey [FK_ArmorUseHistory_Armors]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[ArmorUse]  WITH CHECK ADD  CONSTRAINT [FK_ArmorUseHistory_Armors] FOREIGN KEY([ArmorID])
REFERENCES [dbo].[Armors] ([ID])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[ArmorUse] CHECK CONSTRAINT [FK_ArmorUseHistory_Armors]
GO
/****** Object:  ForeignKey [FK_ArmorUseHistory_Users1]    Script Date: 12/16/2018 14:27:35 ******/
ALTER TABLE [dbo].[ArmorUse]  WITH CHECK ADD  CONSTRAINT [FK_ArmorUseHistory_Users1] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([ID])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[ArmorUse] CHECK CONSTRAINT [FK_ArmorUseHistory_Users1]
GO
