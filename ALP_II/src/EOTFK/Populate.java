package EOTFK;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Populate implements Serializable {

    private List<Area> areas = new ArrayList<>();
    private List<Abilities> abilities = new ArrayList<>();
    private List<Items> storeItems = new ArrayList<>();
    private List<Weapon> storeWeapons = new ArrayList<>();
    private List<Armor> storeArmor = new ArrayList<>();
    private List<Enemy> citadelEnemies = new ArrayList<>();
    private List<Enemy> woodsEnemies = new ArrayList<>();
    private List<Enemy> cavernsEnemies = new ArrayList<>();
    private List<Enemy> peaksEnemies = new ArrayList<>();
    private List<Enemy> depthsEnemies = new ArrayList<>();
    private List<Enemy> bossEnemies = new ArrayList<>();
    private List<Quest> quests = new ArrayList<>();

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

    public List<Quest> getQuests() {
        return quests;
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
        citadelEnemies.add(new Enemy("Bonecrusher Warrior", 2, 10, 25, 25, 5, 2, 1, 1, 25,
                new Weapon("Bone Axe", "A powerful axe made from bone", 5, 2, 100, 100),
                new Armor("Bone Armor", "Armor crafted from sturdy bones", 3, 2, 100, 100, 25)));

        citadelEnemies.add(new Enemy("Cursed Phantom Prince", 4, 20, 35, 35, 10, 4, 2, 1, 35,
                new Weapon("Phantom Blade", "A spectral blade that curses its victims", 8, 4, 100, 100),
                new Armor("Phantom Cloak", "Cloak that renders the wearer ethereal", 5, 4, 100, 100, 35)));

        citadelEnemies.add(new Enemy("Necroshade Princess", 6, 30, 45, 45, 15, 6, 3, 1, 50,
                new Weapon("Necro Staff", "Staff imbued with life-draining magic", 10, 6, 100, 100),
                new Armor("Shade Robe", "Robe that offers protection against shadows", 7, 6, 100, 100, 50)));

        citadelEnemies.add(new Enemy("Titan of Shadows", 8, 40, 55, 55, 20, 8, 4, 1, 60,
                new Weapon("Shadow Hammer", "Massive hammer that stuns enemies with darkness", 12, 8, 100, 100),
                new Armor("Titan Armor", "Heavy armor with shadow-infused shield", 10, 8, 100, 100, 60)));
    }

    public void createWoodsEnemy() {
        woodsEnemies.add(new Enemy("Direbane Wolf", 12, 60, 80, 80, 35, 12, 2, 2, 75,
                new Weapon("Dire Fangs", "Sharp fangs that cause bleeding", 15, 12, 100, 100),
                new Armor("Wolf Pelt", "Pelt providing evasion against attacks", 10, 12, 100, 100, 50)));

        woodsEnemies.add(new Enemy("Spectral Wraith", 14, 70, 90, 90, 40, 14, 2, 2, 85,
                new Weapon("Wraith Claws", "Claws that inflict fear in enemies", 18, 14, 100, 100),
                new Armor("Spectral Veil", "Veil granting incorporeal protection", 12, 14, 100, 100, 60)));

        woodsEnemies.add(new Enemy("Ethereal Forest Spirit", 80, 100, 100, 50, 45, 16, 2, 2, 100,
                new Weapon("Spirit Branch", "Branch with entangling properties", 20, 16, 100, 100),
                new Armor("Forest Essence", "Essence providing regeneration", 15, 16, 100, 100, 75)));

        woodsEnemies.add(new Enemy("Duskblade Elf", 18, 90, 110, 110, 50, 18, 2, 2, 110,
                new Weapon("Duskblade", "Blade coated with poison", 22, 18, 100, 100),
                new Armor("Elven Armor", "Armor enhancing agility", 18, 18, 100, 100, 90)));
    }

    public void createCavernsEnemy() {
        cavernsEnemies.add(new Enemy("Goblin Warlock", 24, 110, 135, 135, 65, 22, 3, 3, 100,
                new Weapon("Warlock Staff", "Staff imbued with hexing magic", 20, 24, 100, 100),
                new Armor("Goblin Robes", "Robes providing magic resistance", 10, 24, 100, 100, 50)));

        cavernsEnemies.add(new Enemy("Ogre Mauler", 28, 120, 145, 145, 70, 24, 3, 3, 125,
                new Weapon("Maul", "Heavy maul for crushing foes", 25, 28, 100, 100),
                new Armor("Ogre Hide", "Thick hide providing toughness", 15, 28, 100, 100, 75)));

        cavernsEnemies.add(new Enemy("Orc Overlord", 32, 130, 155, 155, 75, 26, 3, 3, 150,
                new Weapon("Overlord Axe", "Massive axe wielded by orc overlords", 30, 32, 100, 100),
                new Armor("Orc Plate", "Plate armor enhancing strength", 20, 32, 100, 100, 100)));

        cavernsEnemies.add(new Enemy("Troll Ravager", 36, 140, 165, 165, 80, 28, 3, 3, 175,
                new Weapon("Ravager Club", "Club used by trolls for smashing", 35, 36, 100, 100),
                new Armor("Troll Armor", "Armor providing regeneration", 25, 36, 100, 100, 125)));
    }

    public void createPeaksEnemy() {
        peaksEnemies.add(new Enemy("Frostfire Wyvern", 44, 160, 190, 190, 95, 32, 4, 4, 200,
                new Weapon("Frostfire Breath", "Freezes and burns enemies", 40, 44, 100, 100),
                new Armor("Wyvern Scales", "Scales providing elemental resistance", 30, 44, 100, 100, 100)));

        peaksEnemies.add(new Enemy("Glacial Dragon", 48, 170, 200, 200, 100, 34, 4, 4, 225,
                new Weapon("Glacial Claws", "Claws with freezing power", 45, 48, 100, 100),
                new Armor("Dragonhide", "Tough hide with frost aura", 35, 48, 100, 100, 125)));

        peaksEnemies.add(new Enemy("Inferno Elemental", 52, 180, 210, 210, 105, 36, 4, 4, 250,
                new Weapon("Inferno Flame", "Flames that engulf and burn", 50, 52, 100, 100),
                new Armor("Flame Core", "Core emitting a shield of fire", 40, 52, 100, 100, 150)));

        peaksEnemies.add(new Enemy("Earthshatter Golem", 56, 190, 220, 220, 110, 38, 4, 4, 275,
                new Weapon("Earthshatter Fist", "Fist causing seismic shockwaves", 55, 56, 100, 100),
                new Armor("Golem Stone", "Stone with an earth-shielding property", 45, 56, 100, 100, 175)));
    }

    public void createDepthsEnemy() {
        depthsEnemies.add(new Enemy("Abyssal Nightmare", 64, 210, 245, 245, 125, 42, 5, 5, 300,
                new Weapon("Nightmare Scythe", "Scythe inducing fear", 55, 64, 100, 100),
                new Armor("Abyssal Shroud", "Shroud emitting darkness aura", 45, 64, 100, 100, 200)));

        depthsEnemies.add(new Enemy("Voidshade Demon", 68, 220, 255, 255, 130, 44, 5, 5, 325,
                new Weapon("Void Claws", "Claws draining life force", 60, 68, 100, 100),
                new Armor("Void Armor", "Armor providing shielding from void", 50, 68, 100, 100, 225)));

        depthsEnemies.add(new Enemy("Soul Devourer", 72, 230, 265, 275, 135, 46, 5, 5, 350,
                new Weapon("Soul Reaver", "Reaver absorbing souls", 65, 72, 100, 100),
                new Armor("Devourer Armor", "Armor with life-stealing properties", 55, 72, 100, 100, 250)));

        depthsEnemies.add(new Enemy("Cataclysm Bringer", 76, 240, 285, 285, 140, 48, 5, 5, 375,
                new Weapon("Cataclysm Blade", "Blade bringing destruction", 70, 76, 100, 100),
                new Armor("Cataclysm Plate", "Plate emitting cataclysmic aura", 60, 76, 100, 100, 275)));
    }

    public void createBoss() {
        bossEnemies.add(new Enemy("The Dark Knight", 20, 50, 70, 35, 30, 10, 6, 1, 400,
                new Weapon("Dark Sword", "Sword that slashes through darkness", 40, 20, 100, 100),
                new Armor("Knight's Armor", "Armor worn by the legendary dark knight", 40, 20, 100, 100, 300)));

        bossEnemies.add(new Enemy("Lunar Werewolf", 40, 100, 125, 125, 60, 20, 6, 2, 800,
                new Weapon("Lunar Claws", "Claws imbued with the power of the moon", 80, 40, 200, 200),
                new Armor("Werewolf Fur", "Fur that grants lunar regeneration", 80, 40, 200, 200, 600)));

        bossEnemies.add(new Enemy("Chthonic Dreadlord", 60, 150, 180, 180, 90, 30, 6, 3, 1200,
                new Weapon("Dread Scythe", "Scythe that instills dread in its victims", 120, 60, 300, 300),
                new Armor("Dreadlord's Plate", "Plate armor with dread-infused aura", 120, 60, 300, 300, 900)));

        bossEnemies.add(new Enemy("Thunderclap Serpent", 80, 200, 235, 235, 120, 40, 6, 4, 1600,
                new Weapon("Thunder Fang", "Fangs that summon thunderstorms", 160, 80, 400, 400),
                new Armor("Serpent Scales", "Scales with electrically charged shield", 160, 80, 400, 400, 1200)));

        bossEnemies.add(new Enemy("The Undead Slayer", 100, 250, 300, 300, 150, 50, 6, 5, 2000,
                new Weapon("Slayer's Blade", "Blade that banishes undead spirits", 200, 100, 500, 500),
                new Armor("Slayer's Armor", "Armor with holy aura to repel undead", 200, 100, 500, 500, 1500)));
    }

    public void createQuest() {
        quests.add(
                new Quest("The Lost Artifact",
                        "Retrieve the ancient artifact hidden within the citadel", 1, 100, 100,
                        true, false));
        quests.add(
                new Quest("The Cursed Relic",
                        "Destroy the cursed relic that haunts the whispering woods", 2, 200,
                        200,
                        false, false));
        quests.add(
                new Quest("The Dark Ritual",
                        "Stop the dark ritual being performed in the cursed caverns", 3, 300,
                        300,
                        false, false));
        quests.add(
                new Quest("The Shadowed Tome", "Recover the shadowed tome from the shadowed peaks", 4,
                        400, 400, false,
                        false));
        quests.add(new Quest("The Abyssal Gate", "Close the abyssal gate that leads to the abyssal depths", 5,
                500, 500,
                false, false));
    }
}
