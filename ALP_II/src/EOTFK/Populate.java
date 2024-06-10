package EOTFK;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Populate implements Serializable {

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
                500, true));
        areas.add(new Area("The Whispering Woods", "A dense forest, haunted by the spirits of the past", 2,
                1000, 1000, false));
        areas.add(new Area("The Cursed Caverns", "A labyrinth of tunnels, infested with dark creatures", 3,
                1500,
                1500, false));
        areas.add(new Area("The Shadowed Peaks", "A treacherous mountain range, home to ancient evils", 4, 2000,
                2000, false));
        areas.add(new Area("The Abyssal Depths", "A dark abyss, where forgotten horrors lie in wait", 5, 2500,
                2500, false));
    }

    public void createAbility() {
        abilities.add(new Abilities("Inferno Blast", "Unleash an inferno, engulfing enemies in flames", 1, 10,
                false));
        abilities.add(new Abilities("Frost Nova", "Summon a frigid storm, freezing foes in their tracks", 2, 20,
                false));
        abilities.add(new Abilities("Stormcaller",
                "Harness the power of thunderstorms, striking enemies with lightning", 3, 30, false));
        abilities.add(new Abilities("Tectonic Quake",
                "Shatter the earth beneath your enemies, causing seismic devastation", 4, 40, false));
        abilities
                .add(new Abilities("Tempest Fury",
                        "Summon a tempest, tearing apart enemies with ferocious winds", 5, 50,
                        false));
        abilities
                .add(new Abilities("Shadowstep",
                        "Fade into the shadows, swiftly reappearing behind your enemies", 6, 60,
                        false));
        abilities.add(new Abilities("Ethereal Barrier", "Weave an ethereal barrier, shielding you from harm",
                7, 70, false));
        abilities.add(
                new Abilities("Dragon's Roar",
                        "Unleash the primal roar of a dragon, paralyzing foes with fear", 8, 80,
                        false));
        abilities.add(new Abilities("Soul Siphon",
                "Draw upon the life force of enemies, replenishing your own vitality", 9, 90, false));
        abilities.add(new Abilities("Temporal Shift",
                "Bend time to your will, altering the flow of combat in your favor", 10, 100, false));
    }

    public void createItems() {
        storeItems.add(
                new Items("Ethereal Elixir",
                        "Infused with ethereal energy, restores 100 health and mana", 1,
                        50, 100));
        storeItems.add(new Items("Phoenix Feather",
                "Harnesses the essence of the mythical phoenix, reviving you with full health", 2, 100,
                500));
        storeItems.add(new Items("Potion of Elemental Resistance",
                "Grants temporary resistance against elemental attacks", 3, 25, 50));
        storeItems.add(new Items("Scroll of Teleportation",
                "Allows instantaneous teleportation to a previously visited location", 4, 50, 100));
        storeItems.add(new Items("Crystal of Clarity", "Clears the mind of confusion and restores 50 mana", 5,
                25, 50));
        storeItems.add(new Items("Amulet of Fortune",
                "Bestows luck upon the wearer, increasing chance of finding rare loot", 6, 50, 100));
        storeItems.add(new Items("Vial of Shadows",
                "Cloaks the user in shadows, granting temporary invisibility", 7, 25, 50));
        storeItems.add(new Items("Basilisk Blood",
                "Confers the petrifying gaze of a basilisk, paralyzing enemies", 8, 50, 100));

        storeItems.add(new Items("Orb of Enlightenment", "Reveals hidden knowledge, granting experience points",
                9, 25, 50));

        storeItems.add(
                new Items("Chalice of Renewal",
                        "Renews vitality and strength, restoring 75 health and mana", 10, 25,
                        50));
    }

    public void createWeapon() {
        storeWeapons.add(new Weapon("Elven Longbow", "A masterfully crafted longbow of elven design", 7, 5, 150,
                50));
        storeWeapons.add(new Weapon("Dwarven Warhammer", "A massive warhammer forged in dwarven halls", 8, 15,
                200, 100));
        storeWeapons.add(
                new Weapon("Stormcaller Staff", "A staff imbued with the power of thunderstorms", 9, 25,
                        250, 150));
        storeWeapons.add(new Weapon("Flamebrand Katana", "A katana enchanted with the essence of fire", 10, 35,
                300, 200));
        storeWeapons.add(new Weapon("Soulreaper Scythe", "A grim scythe that reaps souls with every swing", 11,
                45,
                350, 250));
        storeWeapons.add(new Weapon("Frostbite Axe", "An axe forged in the heart of a blizzard", 12, 55, 400,
                300));
        storeWeapons.add(new Weapon("Venomous Dagger", "A dagger coated in deadly venom", 13, 65, 450, 350));
        storeWeapons.add(new Weapon("Celestial Staff", "A staff infused with celestial energies", 14, 75, 500,
                400));
        storeWeapons.add(new Weapon("Voidblade Saber", "A saber crafted from the essence of the void", 15, 85,
                550, 450));
        storeWeapons.add(new Weapon("Arcane Wand", "A wand crackling with arcane power", 16, 95, 600, 500));
    }

    public void createArmor() {
        storeArmor.add(new Armor("Shadowweave Vestments", "Dark vestments woven from shadowy threads", 7, 5,
                150,
                50, 50));
        storeArmor.add(new Armor("Stormforged Mail", "Mail armor forged in the heart of a raging storm", 8, 15,
                200, 75, 75));
        storeArmor.add(new Armor("Mithril Plate", "Durable plate armor crafted from rare mithril", 9, 25, 250,
                100, 100));
        storeArmor.add(new Armor("Phoenix Guard", "Armor infused with the essence of a phoenix", 10, 35, 300,
                125, 125));
        storeArmor.add(new Armor("Dragonscale Hauberk", "Hauberk made from the scales of a legendary dragon",
                11, 45, 350, 150, 150));
        storeArmor.add(new Armor("Elven Silk Robes", "Exquisite robes made from enchanted elven silk", 12, 55,
                400, 175, 175));
        storeArmor.add(new Armor("Dragon Scale Armor", "Armor crafted from the scales of a slain dragon", 13,
                65, 450, 200, 200));
        storeArmor.add(
                new Armor("Celestial Plate", "Armor infused with celestial energy", 14, 75, 500, 225,
                        225));
        storeArmor.add(new Armor("Shadow Cloak", "Cloak that grants invisibility in shadows", 15, 85, 550, 250,
                250));
        storeArmor.add(new Armor("Titanium Warplate", "Imposing warplate forged from rare titanium", 16, 95,
                600, 275, 275));
    }

    public void createCitadelEnemy() {
        citadelEnemies.add(new Enemy("Bonecrusher Warrior", 2, 50, 35, 35, 8, 4, 1, 1, 10,
                
                new Weapon("Bone Axe", "A powerful axe made from bone", 17, 2, 10, 12),
                new Armor("Bone Armor", "Armor crafted from sturdy bones", 17, 2, 10, 6,
                        10)));
        citadelEnemies.add(new Enemy("Cursed Phantom Prince", 4, 75, 50, 50, 11, 7, 1, 1, 20,
                new Weapon("Phantom Blade", "A spectral blade that curses its victims", 18, 4, 20,
                        19),
                new Armor("Phantom Cloak", "Cloak that renders the wearer ethereal", 18, 4, 20, 8,
                        15)));
        citadelEnemies.add(new Enemy("Necroshade Princess", 6, 100, 70, 70, 15, 8, 1, 1, 30,
                new Weapon("Necro Staff", "Staff imbued with life-draining magic", 19, 6, 30, 15),
                new Armor("Shade Robe", "Robe that offers protection against shadows", 19, 6, 30, 12,
                        20)));
        citadelEnemies.add(new Enemy("Titan of Shadows", 8, 150, 90, 90, 18, 12, 1, 1, 40,
                new Weapon("Shadow Hammer", "Massive hammer that stuns enemies with darkness", 20, 8,
                        40, 22),
                new Armor("Titan Armor", "Heavy armor with shadow-infused shield", 20, 8, 40, 13,
                        30)));
    }

    public void createWoodsEnemy() {
        woodsEnemies.add(new Enemy("Direbane Wolf", 12, 325, 275, 275, 35, 25, 2, 2, 210,
                new Weapon("Dire Fangs", "Sharp fangs that cause bleeding", 21, 5, 100, 100),
                new Armor("Wolf Pelt", "Pelt providing evasion against attacks", 21, 5, 100, 100,
                        100)));
        woodsEnemies.add(new Enemy("Spectral Wraith", 14, 350, 295, 295, 38, 29, 2, 2, 220,
                new Weapon("Wraith Claws", "Claws that inflict fear in enemies", 22, 5, 100, 100),
                new Armor("Spectral Veil", "Veil granting incorporeal protection", 22, 5, 100, 100,
                        100)));
        woodsEnemies.add(new Enemy("Ethereal Forest Spirit", 16, 375, 310, 310, 42, 32, 2, 2, 230,
                new Weapon("Spirit Branch", "Branch with entangling properties", 23, 5, 100, 100),
                new Armor("Forest Essence", "Essence providing regeneration", 23, 5, 100, 100,
                        100)));
        woodsEnemies.add(new Enemy("Duskblade Elf", 18, 400, 330, 330, 45, 35, 2, 2, 240,
                new Weapon("Duskblade", "Blade coated with poison", 24, 5, 100, 100),
                new Armor("Elven Armor", "Armor enhancing agility", 24, 5, 100, 100,
                        100)));
    }

    public void createCavernsEnemy() {
        cavernsEnemies.add(new Enemy("Goblin Warlock", 22, 825, 475, 475, 90, 50, 3, 3, 410,
                new Weapon("Warlock Staff", "Staff imbued with hexing magic", 25, 5, 100, 100),
                new Armor("Goblin Robes", "Robes providing magic resistance", 25, 5, 100, 100, 100)));
        cavernsEnemies.add(new Enemy("Ogre Mauler", 24, 850, 500, 500, 93, 52, 3, 3, 420,
                new Weapon("Maul", "Heavy maul for crushing foes", 26, 5, 100, 100),
                new Armor("Ogre Hide", "Thick hide providing toughness", 26, 5, 100, 100, 100)));
        cavernsEnemies.add(new Enemy("Orc Overlord", 26, 900, 525, 525, 95, 55, 3, 3, 430,
                new Weapon("Overlord Axe", "Massive axe wielded by orc overlords", 27, 5, 100, 100),
                new Armor("Orc Plate", "Plate armor enhancing strength", 27, 5, 100, 100, 100)));
        cavernsEnemies.add(new Enemy("Troll Ravager", 28, 925, 575, 575, 110, 58, 3, 3, 440,
                new Weapon("Ravager Club", "Club used by trolls for smashing", 29, 5, 100, 100),
                new Armor("Troll Armor", "Armor providing regeneration", 29, 5, 100, 100, 100)));
    }

    public void createPeaksEnemy() {
        peaksEnemies.add(new Enemy("Frostfire Wyvern", 32, 1325, 675, 675, 133, 72, 4, 4, 610,
                new Weapon("Frostfire Breath", "Freezes and burns enemies", 30, 5, 100, 100),
                new Armor("Wyvern Scales", "Scales providing elemental resistance", 30, 5, 100, 100,
                        100)));

        peaksEnemies.add(new Enemy("Glacial Dragon", 34, 1350, 700, 700, 135, 75, 4, 4, 620,
                new Weapon("Glacial Claws", "Claws with freezing power", 31, 5, 100, 100),
                new Armor("Dragonhide", "Tough hide with frost aura", 31, 5, 100, 100, 100)));

        peaksEnemies.add(new Enemy("Inferno Elemental", 36, 1375, 750, 750, 138, 77, 4, 4, 630,
                new Weapon("Inferno Flame", "Flames that engulf and burn", 32, 5, 100, 100),
                new Armor("Flame Core", "Core emitting a shield of fire", 32, 5, 100, 100, 100)));

        peaksEnemies.add(new Enemy("Earthshatter Golem", 38, 1400, 775, 775, 142, 80, 4, 4, 640,
                new Weapon("Earthshatter Fist", "Fist causing seismic shockwaves", 33, 5, 100, 100),
                new Armor("Golem Stone", "Stone with an earth-shielding property", 33, 5, 100, 100,
                        100)));
    }

    public void createDepthsEnemy() {
        depthsEnemies.add(new Enemy("Abyssal Nightmare", 42, 1850, 875, 875, 182, 98, 5, 5, 810,
                new Weapon("Nightmare Scythe", "Scythe inducing fear", 34, 5, 100, 100),
                new Armor("Abyssal Shroud", "Shroud emitting darkness aura", 34, 5, 100, 100, 100)));

        depthsEnemies.add(new Enemy("Voidshade Demon", 44, 1875, 50, 50, 185, 100, 5, 5, 820,
                new Weapon("Void Claws", "Claws draining life force", 35, 5, 100, 100),
                new Armor("Void Armor", "Armor providing shielding from void", 35, 5, 100, 100, 100)));

        depthsEnemies.add(new Enemy("Soul Devourer", 46, 1900, 50, 50, 189, 103, 5, 5, 830,
                new Weapon("Soul Reaver", "Reaver absorbing souls", 36, 5, 100, 100),
                new Armor("Devourer Armor", "Armor with life-stealing properties", 36, 5, 100, 100,
                        100)));

        depthsEnemies.add(new Enemy("Cataclysm Bringer", 48, 1925, 50, 50, 195, 105, 5, 5, 840,
                new Weapon("Cataclysm Blade", "Blade bringing destruction", 37, 5, 100, 100),
                new Armor("Cataclysm Plate", "Plate emitting cataclysmic aura", 37, 5, 100, 100, 100)));
    }

    public void createBoss() {
        bossEnemies.add(new Enemy("The Dark Knight", 10, 300, 250, 250, 30, 20, 6, 1, 200,
                new Weapon("Dark Sword", "Sword that slashes through darkness", 2, 10, 200, 30),
                new Armor("Knight's Armor", "Armor worn by the legendary dark knight", 2, 20, 100, 20,
                        50)));

        bossEnemies.add(new Enemy("Lunar Werewolf", 20, 800, 450, 450, 80, 45, 6, 2, 400,
                new Weapon("Lunar Claws", "Claws imbued with the power of the moon", 3, 40, 200, 200),
                new Armor("Werewolf Fur", "Fur that grants lunar regeneration", 3, 40, 200, 200,
                        200)));

        bossEnemies.add(new Enemy("Chthonic Dreadlord", 30, 1300, 650, 650, 130, 70, 6, 3, 600,
                new Weapon("Dread Scythe", "Scythe that instills dread in its victims", 4, 60, 300,
                        300),
                new Armor("Dreadlord's Plate", "Plate armor with dread-infused aura", 4, 60, 300, 300,
                        300)));

        bossEnemies.add(new Enemy("Thunderclap Serpent", 40, 1800, 850, 850, 180, 95, 6, 4, 800,
                new Weapon("Thunder Fang", "Fangs that summon thunderstorms", 5, 80, 400, 400),
                new Armor("Serpent Scales", "Scales with electrically charged shield", 5, 80, 400, 400,
                        400)));

        bossEnemies.add(new Enemy("The Undead Slayer", 50, 2300, 1050, 1050, 230, 120, 6, 5, 1000,
                new Weapon("Slayer's Blade", "Blade that banishes undead spirits", 6, 100, 500, 500),
                new Armor("Slayer's Armor", "Armor with holy aura to repel undead", 6, 100, 500, 500,
                        500)));
    }
}
