package EOTFK;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Populate implements Serializable {

        Random rand;

        private final List<Area> areas = new ArrayList<>();
        private final List<Abilities> abilities = new ArrayList<>();
        private final List<Items> storeItems = new ArrayList<>();
        private final List<Weapon> storeWeapons = new ArrayList<>();
        private final List<Armor> storeArmor = new ArrayList<>();
        private final List<Enemy> citadelEnemies = new ArrayList<>();
        private final List<Enemy> woodsEnemies = new ArrayList<>();
        private final List<Enemy> cavernsEnemies = new ArrayList<>();
        private final List<Enemy> peaksEnemies = new ArrayList<>();
        private final List<Enemy> depthsEnemies = new ArrayList<>();
        private final List<Enemy> bossEnemies = new ArrayList<>();

        public Populate() {
                rand = new Random();
        }

        public List<Area> getAreas() {
                return areas;
        }

        public List<Abilities> getAbilities() {
                return abilities;
        }

        public List<Items> getStoreItems() {
                return storeItems;
        }

        public List<Weapon> getStoreWeapons() {
                return storeWeapons;
        }

        public List<Armor> getStoreArmor() {
                return storeArmor;
        }

        public List<Enemy> getCitadelEnemies() {
                return citadelEnemies;
        }

        public List<Enemy> getWoodsEnemies() {
                return woodsEnemies;
        }

        public List<Enemy> getCavernsEnemies() {
                return cavernsEnemies;
        }

        public List<Enemy> getPeaksEnemies() {
                return peaksEnemies;
        }

        public List<Enemy> getDepthsEnemies() {
                return depthsEnemies;
        }

        public List<Enemy> getBossEnemies() {
                return bossEnemies;
        }

        public void createArea() {
                areas.add(new Area("The Forgotten Citadel", "An ancient citadel, shrouded in mystery and shadows", 1,
                                500,
                                500, true, false));
                areas.add(new Area("The Whispering Woods", "A dense forest, haunted by the spirits of the past", 2,
                                1000, 1000, false, false));
                areas.add(new Area("The Cursed Caverns", "A labyrinth of tunnels, infested with dark creatures", 3,
                                1500, 1500, false, false));
                areas.add(new Area("The Shadowed Peaks", "A treacherous mountain range, home to ancient evils", 4, 2000,
                                2000, false, false));
                areas.add(new Area("The Abyssal Depths", "A dark abyss, where forgotten horrors lie in wait", 5, 2500,
                                2500, false, false));
        }

        public void createItems() {
                storeItems.add(new Items("Health Potion", "Restores 20 Health", 1, 10));
                storeItems.add(new Items("Mana Potion", "Restores 10 Mana", 2, 10));
                storeItems.add(new Items("Ethereal Elixir",
                                "Infused with ethereal energy, Restores 100 Health and Mana", 3,
                                100));
                storeItems.add(new Items("Phoenix Feather",
                                "Harnesses the essence of the mythical phoenix, healing you with full health", 4,
                                100));
                storeItems.add(new Items("Orb of Enlightenment", "Reveals hidden knowledge, granting experience points",
                                5, 50));
        }

        public void createWeapon() {
                storeWeapons.add(new Weapon("Elven Longbow", "A masterfully crafted longbow of elven design", 7, 5, 150,
                                50));
                storeWeapons.add(new Weapon("Dwarven Warhammer", "A massive warhammer forged in dwarven halls", 8, 10,
                                200, 100));
                storeWeapons.add(
                                new Weapon("Stormcaller Staff", "A staff imbued with the power of thunderstorms", 9, 15,
                                                250, 150));
                storeWeapons.add(new Weapon("Flamebrand Katana", "A katana enchanted with the essence of fire", 10, 20,
                                300, 200));
                storeWeapons.add(new Weapon("Soulreaper Scythe", "A grim scythe that reaps souls with every swing", 11,
                                25,
                                350, 250));
                storeWeapons.add(new Weapon("Frostbite Axe", "An axe forged in the heart of a blizzard", 12, 30, 400,
                                300));
                storeWeapons.add(new Weapon("Venomous Dagger", "A dagger coated in deadly venom", 13, 35, 450, 350));
                storeWeapons.add(new Weapon("Celestial Staff", "A staff infused with celestial energies", 14, 35, 500,
                                400));
                storeWeapons.add(new Weapon("Voidblade Saber", "A saber crafted from the essence of the void", 15, 40,
                                550, 450));
                storeWeapons.add(new Weapon("Arcane Wand", "A wand crackling with arcane power", 16, 45, 600, 500));
        }

        public void createArmor() {
                storeArmor.add(new Armor("Shadowweave Vestments", "Dark vestments woven from shadowy threads", 7, 5,
                                150,
                                50, 50));
                storeArmor.add(new Armor("Stormforged Mail", "Mail armor forged in the heart of a raging storm", 8, 10,
                                200, 75, 75));
                storeArmor.add(new Armor("Mithril Plate", "Durable plate armor crafted from rare mithril", 9, 15, 250,
                                100, 100));
                storeArmor.add(new Armor("Phoenix Guard", "Armor infused with the essence of a phoenix", 10, 20, 300,
                                125, 125));
                storeArmor.add(new Armor("Dragonscale Hauberk", "Hauberk made from the scales of a legendary dragon",
                                11, 25, 350, 150, 150));
                storeArmor.add(new Armor("Elven Silk Robes", "Exquisite robes made from enchanted elven silk", 12, 30,
                                400, 175, 175));
                storeArmor.add(new Armor("Dragon Scale Armor", "Armor crafted from the scales of a slain dragon", 13,
                                65, 450, 200, 200));
                storeArmor.add(new Armor("Celestial Plate", "Armor infused with celestial energy", 14, 35, 500, 225,
                                225));
                storeArmor.add(new Armor("Shadow Cloak", "Cloak that grants invisibility in shadows", 15, 40, 550, 250,
                                250));
                storeArmor.add(new Armor("Titanium Warplate", "Imposing warplate forged from rare titanium", 16, 45,
                                600, 275, 275));
        }

        public void createCitadelEnemy() {
                citadelEnemies.add(new Enemy("Bonecrusher Warrior", 2, 50, 35, 35, 8, 4, 1, 1, 0, 10,
                                new Weapon("Bone Axe", "A powerful axe made from bone", 17, 2, 30, 5),
                                new Armor("Bone Armor", "Armor crafted from sturdy bones", 17, 2, 30, 5,
                                                10)));
                citadelEnemies.add(new Enemy("Cursed Phantom Prince", 4, 75, 50, 50, 11, 7, 2, 1, 0, 20,
                                new Weapon("Phantom Blade", "A spectral blade that curses its victims", 18, 4, 40,
                                                8),
                                new Armor("Phantom Cloak", "Cloak that renders the wearer ethereal", 18, 4, 40, 8,
                                                12)));
                citadelEnemies.add(new Enemy("Necroshade Princess", 6, 100, 70, 70, 15, 8, 3, 1, 0, 30,
                                new Weapon("Necro Staff", "Staff imbued with life-draining magic", 19, 6, 40, 10),
                                new Armor("Shade Robe", "Robe that offers protection against shadows", 19, 6, 40, 10,
                                                15)));
                citadelEnemies.add(new Enemy("Titan of Shadows", 8, 150, 90, 90, 18, 12, 4, 1, 0, 40,
                                new Weapon("Shadow Hammer", "Massive hammer that stuns enemies with darkness", 20, 8,
                                                50, 12),
                                new Armor("Titan Armor", "Heavy armor with shadow-infused shield", 20, 8, 50, 13,
                                                18)));
        }

        public void createWoodsEnemy() {
                woodsEnemies.add(new Enemy("Direbane Wolf", 12, 325, 275, 275, 35, 25, 1, 2, 0, 110,
                                new Weapon("Dire Fangs", "Sharp fangs that cause bleeding", 21, 12, 80, 22),
                                new Armor("Wolf Pelt", "Pelt providing evasion against attacks", 21, 12, 80, 22,
                                                27)));
                woodsEnemies.add(new Enemy("Spectral Wraith", 14, 350, 295, 295, 38, 29, 2, 2, 0, 120,
                                new Weapon("Wraith Claws", "Claws that inflict fear in enemies", 22, 14, 90, 24),
                                new Armor("Spectral Veil", "Veil granting incorporeal protection", 22, 14, 90, 23,
                                                30)));
                woodsEnemies.add(new Enemy("Ethereal Forest Spirit", 16, 375, 310, 310, 42, 32, 3, 2, 0, 130,
                                new Weapon("Spirit Branch", "Branch with entangling properties", 23, 16, 100, 27),
                                new Armor("Forest Essence", "Essence providing regeneration", 23, 16, 100, 27,
                                                33)));
                woodsEnemies.add(new Enemy("Duskblade Elf", 18, 400, 330, 330, 45, 35, 4, 2, 0, 140,
                                new Weapon("Duskblade", "Blade coated with poison", 24, 18, 110, 30),
                                new Armor("Elven Armor", "Armor enhancing agility", 24, 18, 110, 30,
                                                35)));
        }

        public void createCavernsEnemy() {
                cavernsEnemies.add(new Enemy("Goblin Warlock", 22, 825, 475, 475, 90, 50, 1, 3, 0, 210,
                                new Weapon("Warlock Staff", "Staff imbued with hexing magic", 25, 22, 150, 37),
                                new Armor("Goblin Robes", "Robes providing magic resistance", 25, 22, 150, 40, 43)));
                cavernsEnemies.add(new Enemy("Ogre Mauler", 24, 850, 500, 500, 93, 52, 2, 3, 0, 220,
                                new Weapon("Maul", "Heavy maul for crushing foes", 26, 24, 160, 40),
                                new Armor("Ogre Hide", "Thick hide providing toughness", 26, 24, 160, 42, 45)));
                cavernsEnemies.add(new Enemy("Orc Overlord", 26, 900, 525, 525, 95, 55, 3, 3, 0, 230,
                                new Weapon("Overlord Axe", "Massive axe wielded by orc overlords", 27, 26, 170, 45),
                                new Armor("Orc Plate", "Plate armor enhancing strength", 27, 5, 170, 45, 48)));
                cavernsEnemies.add(new Enemy("Troll Ravager", 28, 925, 575, 575, 110, 58, 4, 3, 0, 240,
                                new Weapon("Ravager Club", "Club used by trolls for smashing", 29, 28, 180, 48),
                                new Armor("Troll Armor", "Armor providing regeneration", 29, 5, 180, 50, 50)));
        }

        public void createPeaksEnemy() {
                peaksEnemies.add(new Enemy("Frostfire Wyvern", 32, 1325, 675, 675, 133, 72, 1, 4, 0, 310,
                                new Weapon("Frostfire Breath", "Freezes and burns enemies", 30, 32, 210, 55),
                                new Armor("Wyvern Scales", "Scales providing elemental resistance", 30, 32, 210, 55,
                                                65)));

                peaksEnemies.add(new Enemy("Glacial Dragon", 34, 1350, 700, 700, 135, 75, 2, 4, 0, 320,
                                new Weapon("Glacial Claws", "Claws with freezing power", 31, 34, 220, 57),
                                new Armor("Dragonhide", "Tough hide with frost aura", 31, 34, 220, 58, 70)));

                peaksEnemies.add(new Enemy("Inferno Elemental", 36, 1375, 750, 750, 138, 77, 3, 4, 0, 330,
                                new Weapon("Inferno Flame", "Flames that engulf and burn", 32, 36, 230, 60),
                                new Armor("Flame Core", "Core emitting a shield of fire", 32, 36, 230, 60, 75)));

                peaksEnemies.add(new Enemy("Earthshatter Golem", 38, 1400, 775, 775, 142, 80, 4, 4, 0, 340,
                                new Weapon("Earthshatter Fist", "Fist causing seismic shockwaves", 33, 38, 240, 63),
                                new Armor("Golem Stone", "Stone with an earth-shielding property", 33, 38, 240, 62,
                                                80)));
        }

        public void createDepthsEnemy() {
                depthsEnemies.add(new Enemy("Abyssal Nightmare", 42, 1850, 875, 875, 182, 98, 1, 5, 0, 410,
                                new Weapon("Nightmare Scythe", "Scythe inducing fear", 34, 42, 270, 73),
                                new Armor("Abyssal Shroud", "Shroud emitting darkness aura", 34, 42, 270, 72, 110)));

                depthsEnemies.add(new Enemy("Voidshade Demon", 44, 1875, 50, 50, 185, 100, 2, 5, 0, 420,
                                new Weapon("Void Claws", "Claws draining life force", 35, 44, 280, 75),
                                new Armor("Void Armor", "Armor providing shielding from void", 35, 44, 280, 75, 115)));

                depthsEnemies.add(new Enemy("Soul Devourer", 46, 1900, 50, 50, 189, 103, 3, 5, 0, 430,
                                new Weapon("Soul Reaver", "Reaver absorbing souls", 36, 46, 290, 77),
                                new Armor("Devourer Armor", "Armor with life-stealing properties", 36, 46, 290, 78,
                                                120)));

                depthsEnemies.add(new Enemy("Cataclysm Bringer", 48, 1925, 50, 50, 195, 105, 4, 5, 0, 440,
                                new Weapon("Cataclysm Blade", "Blade bringing destruction", 37, 48, 300, 82),
                                new Armor("Cataclysm Plate", "Plate emitting cataclysmic aura", 37, 48, 300, 80, 125)));
        }

        public void createBoss() {
                bossEnemies.add(new Enemy("The Dark Knight", 10, 300, 250, 250, 30, 20, 5, 5, 1, 200,
                                new Weapon("Dark Sword", "Sword that slashes through darkness", 2, 10, 70, 20),
                                new Armor("Knight's Armor", "Armor worn by the legendary dark knight", 2, 10, 70, 20,
                                                25)));

                bossEnemies.add(new Enemy("Lunar Werewolf", 20, 800, 450, 450, 80, 45, 5, 5, 2, 400,
                                new Weapon("Lunar Claws", "Claws imbued with the power of the moon", 3, 20, 130, 35),
                                new Armor("Werewolf Fur", "Fur that grants lunar regeneration", 3, 20, 130, 37,
                                                40)));

                bossEnemies.add(new Enemy("Chthonic Dreadlord", 30, 1300, 650, 650, 130, 70, 5, 5, 3, 600,
                                new Weapon("Dread Scythe", "Scythe that instills dread in its victims", 4, 30, 200,
                                                52),
                                new Armor("Dreadlord's Plate", "Plate armor with dread-infused aura", 4, 30, 200, 52,
                                                60)));

                bossEnemies.add(new Enemy("Thunderclap Serpent", 40, 1800, 850, 850, 180, 95, 5, 5, 4, 800,
                                new Weapon("Thunder Fang", "Fangs that summon thunderstorms", 5, 40, 260, 70),
                                new Armor("Serpent Scales", "Scales with electrically charged shield", 5, 40, 260, 70,
                                                100)));

                bossEnemies.add(new Enemy("The Undead Slayer", 50, 2300, 1050, 1050, 230, 120, 5, 5, 5, 1000,
                                new Weapon("Slayer's Blade", "Blade that banishes undead spirits", 6, 50, 350, 100),
                                new Armor("Slayer's Armor", "Armor with holy aura to repel undead", 6, 50, 350, 120,
                                                150)));
        }

        public void createAbility() {
                abilities.add(new Abilities("Inferno Blast", "Unleash an inferno, engulfing enemies in flames", 1, 5, 1,
                                true));
                abilities.add(new Abilities("Frost Nova", "Summon a frigid storm, freezing foes in their tracks", 2, 5, 5,
                                false));
                abilities.add(new Abilities("Stormcaller",
                                "Harness the power of thunderstorms, striking enemies with lightning", 3, 7, 10, false));
                abilities.add(new Abilities("Tectonic Quake",
                                "Shatter the earth beneath your enemies, causing seismic devastation", 4, 7, 15, false));
                abilities.add(new Abilities("Glacial Cataclysm",
                                "Unleash a devastating wave of ice, shattering and freezing enemies", 5, 10, 20, false));
                abilities.add(new Abilities("Shadowstep",
                                "Fade into the shadows, swiftly reappearing behind your enemies", 6, 10, 25, false));
                abilities.add(new Abilities("Scorching Flames",
                                "Unleash a wave of scorching flames, incinerating all nearby enemies", 7, 15,
                                30, false));
                abilities.add(new Abilities("Dragon's Roar",
                                "Unleash the primal roar of a dragon, paralyzing foes with fear", 8, 15, 35, false));
                abilities.add(new Abilities("Soul Siphon",
                                "Draw upon the life force of enemies, replenishing your own health", 9, 20, 40, false));
                abilities.add(new Abilities("Celestial Wrath",
                                "Call upon the fury of the heavens, smiting enemies with divine power", 10, 30, 45, false));
        }

        public void burn(Enemy enemy) {
                int burnChance = rand.nextInt(100);
                if (burnChance <= 25) {
                        System.out.println("You have burned the enemy!");
                }
                for (int i = 0; i < 3; i++) {
                        enemy.setHealth(Math.ceil(enemy.getHealth() - 0.05 * enemy.getHealth()));
                }
        }

        public void burnPlayer(Player player) {
                int burnChance = rand.nextInt(100);
                if (burnChance <= 25) {
                        System.out.println("You have burned the enemy!");
                }
                for (int i = 0; i < 3; i++) {
                        player.setHealth(Math.ceil(player.getHealth() - 0.05 * player.getHealth()));
                }
        }

        public boolean freeze() {
                int freezeChance = rand.nextInt(100);
                return freezeChance <= 25;
        }

        public boolean paralyze() {
                int paralyzeChance = rand.nextInt(100);
                return paralyzeChance <= 35;
        }

        public boolean confuse() {
                int confusedChance = rand.nextInt(100);
                return confusedChance <= 10;
        }
}
