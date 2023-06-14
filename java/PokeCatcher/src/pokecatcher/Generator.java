
package pokecatcher;
import java.util.Random;

/**
 *
 * @author David
 */
public class Generator {
    private static Random rand = new Random();
    private static int nameNum, dexNum;
    private static String name;
    private static double catchRate;
    private static Pokemon p1;

    public Generator(){
        
    }
    
    public static Pokemon genPoke(){
        p1 = new Pokemon (generateName(), generateCatchRate(), 500);
        return p1;
    }
    
    private static String generateName(){
    nameNum = rand.nextInt(721)+1;
    dexNum = nameNum;
    switch(nameNum){
        case 1:
            name = "Bulbasaur";
            break;
        case 2:
            name = "Ivysaur";
            break;
        case 3:
            name = "Venasaur";
            break;
        case 4:
            name = "Charmander";
            break;
        case 5:
            name = "Charmeleon";
            break;
        case 6:    
            name = "Charizard";
            break;
        case 7:
            name = "Squirtle";
            break;
        case 8:
            name = "Wartortle";
            break;
        case 9:
            name = "Blastoise";
            break;
        case 10:
            name = "Caterpie";
            break;
        case 11:
            name = "Metapod";
            break;
        case 12:
            name = "Butterfree";
            break;
        case 13:
            name = "Weedle";
            break;
        case 14:
            name = "Kakuna";
            break;
        case 15:
            name = "Beedrill";
            break;
        case 16:
            name = "Pidgey";
            break;
        case 17:
            name = "Pidgeotto";
            break;
        case 18:
            name = "Pidgeot";
            break;
        case 19:
            name = "Rattata";
            break;
        case 20:
            name = "Raticate";
            break;
        case 21:
            name = "Spearow";
            break;
        case 22:
            name = "Fearow";
            break;
        case 23:
            name = "Ekans";
            break; 
        case 24:
            name = "Arbok";
            break;
        case 25:
            name = "Pikachu";
            break;
        case 26:
            name = "Raichu";
            break;
        case 27:
            name = "Sandshrew";
            break;
        case 28:
            name = "Sandslash";
            break;
        case 29:
            name = "Nidoran♀";
            break;
        case 30:
            name = "Nidorina";
            break;
        case 31:
            name = "Nidoqueen";
            break;
        case 32:
            name = "Nidoran♂";
            break;
        case 33:
            name = "Nidorino";
            break;
        case 34:
            name = "Nidoking";
            break;
        case 35:
            name = "Clefairy";
            break;
        case 36:
            name = "Clefable";
            break;
        case 37:
            name = "Vulpix";
            break;
        case 38:
            name = "Ninetales";
            break;
        case 39:
            name = "Jigglypuff";
            break;
        case 40:
            name = "Wigglytuff";
            break;
        case 41:
            name = "Zubat";
            break;
        case 42:
            name = "Golbat";
            break;
        case 43:
            name = "Oddish";
            break;
        case 44:
            name = "Gloom";
            break;
        case 45:
            name = "Vileplume";
            break;
        case 46:
            name = "Paras";
            break;
        case 47:
            name = "Parasect";
            break;
        case 48:
            name = "Venonat";
            break;
        case 49:
            name = "Venomoth";
            break;
        case 50:
            name = "Diglett";
            break;
        case 51:
            name = "Dugtrio";
            break;
        case 52:
            name = "Meowth";
            break;
        case 53:
            name = "Persian";
            break;
        case 54:
            name = "Psyduck";
            break;
        case 55:
            name = "Golduck";
            break;
        case 56:
            name = "Mankey";
            break;
        case 57:
            name = "Primeape";
            break;
        case 58:
            name = "Growlithe";
            break;
        case 59:
            name = "Arcanine";
            break;
        case 60:
            name = "Poliwag";
            break;
        case 61:
            name = "Poliwhirl";
            break;
        case 62:
            name = "Poliwrath";
            break;
        case 63:
            name = "Abra";
            break;
        case 64:
            name = "Kadabra";
            break;
        case 65:
            name = "Alakazam";
            break;
        case 66:
            name = "Machop";
            break;
        case 67:
            name = "Machoke";
            break;
        case 68:
            name = "Machamp";
            break;
        case 69:
            name = "Bellsprout";
            break;
        case 70:
            name = "Weepinbell";
            break;
        case 71:
            name = "Victreebel";
            break;
        case 72:
            name = "Tentacool";
            break;
        case 73:
            name = "Tentacruel";
            break;
        case 74:
            name = "Geodude";
            break;
        case 75:
            name = "Graveler";
            break;
        case 76:
            name = "Golem";
            break;
        case 77:
            name = "Ponyta";
            break;
        case 78:
            name = "Rapidash";
            break;
        case 79:
            name = "Slowpoke";
            break;
        case 80:
            name = "Slowbro";
            break;
        case 81:
            name = "Magnemite";
            break;
        case 82:
            name = "Magneton";
            break;
        case 83:
            name = "Farfetch'd";
            break;
        case 84:
            name = "Doduo";
            break;
        case 85:
            name = "Dodrio";
            break;
        case 86:
            name = "Seel";
            break;
        case 87:
            name = "Dewgong";
            break;
        case 88:
            name = "Grimer";
            break;
        case 89:
            name = "Muk";
            break;
        case 90:
            name = "Shellder";
            break;
        case 91:
            name = "Cloyster";
            break;
        case 92:
            name = "Gastly";
            break;
        case 93:
            name = "Haunter";
            break;
        case 94:
            name = "Gengar";
            break;
        case 95:
            name = "Onix";
            break;
        case 96:
            name = "Drowzee";
            break;
        case 97:
            name = "Hypno";
            break;
        case 98:
            name = "Krabby";
            break;
        case 99:
            name = "Kingler";
            break;
        case 100:
            name = "Voltorb";
            break;
        case 101:
            name = "Electrode";
            break;
        case 102:
            name = "Exeggcute";
            break;
        case 103:
            name = "Exeggutor";
            break;
        case 104:
            name = "Cubone";
            break;
        case 105:
            name = "Marowak";
            break;
        case 106:
            name = "Hitmonlee";
            break;
        case 107:
            name = "Hitmonchan";
            break;
        case 108:
            name = "Lickitung";
            break;
        case 109:
            name = "Koffing";
            break;
        case 110:
            name = "Wheezing";
            break;
        case 111:
            name = "Rhyhorn";
            break;
        case 112:
            name = "Rhydon";
            break;
        case 113:
            name = "Chansey";
            break;
        case 114:
            name = "Tangela";
            break;
        case 115:
            name = "Kangaskhan";
            break;
        case 116:
            name = "Horsea";
            break;
        case 117:
            name = "Seadra";
            break;
        case 118:
            name = "Goldeen";
            break;
        case 119:
            name = "Seaking";
            break;
        case 120:
            name = "Staryu";
            break;
        case 121:
            name = "Starmie";
            break;
        case 122:
            name = "Mr. Mime";
            break;
        case 123:
            name = "Scyther";
            break;
        case 124:
            name = "Jynx";
            break;
        case 125:
            name = "Electabuzz";
            break;
        case 126:
            name = "Magmar";
            break;
        case 127:
            name = "Pinsir";
            break;
        case 128:
            name = "Tauros";
            break;
        case 129:
            name = "Magikarp";
            break;
        case 130:
            name = "Gyrados";
            break;
        case 131:
            name = "Lapras";
            break;
        case 132:
            name = "Ditto";
            break;
        case 133:
            name = "Eevee";
            break;
        case 134:
            name = "Vaporeon";
            break;
        case 135:
            name = "Jolteon";
            break;
        case 136:
            name = "Flareon";
            break; 
        case 137:
            name = "Porygon";
            break;
        case 138:
            name = "Omanyte";
            break;
        case 139:
            name = "Omastar";
            break;
        case 140:
            name = "Kabuto";
            break;
        case 141:
            name = "Kabutops";
            break;
        case 142:
            name = "Aerodactyl";
            break;
        case 143:
            name = "Snorlax";
            break;
        case 144:
            name = "Articuno";
            break;
        case 145:
            name = "Zapdos";
            break;
        case 146:
            name = "Moltres";
            break;
        case 147:
            name = "Dratini";
            break;
        case 148:
            name = "Dragonair";
            break;
        case 149:
            name = "Dragonite";
            break;
        case 150:
            name = "Mewtwo";
            break;
        case 151:
            name = "Mew";
            break;
        case 152:
            name = "Chikorita";
            break;
        case 153:
            name = "Bayleef";
            break;
        case 154:
            name = "Meganium";
            break;
        case 155:
            name = "Cyndaquil";
            break;
        case 156:
            name = "Quilava";
            break;
        case 157:
            name = "Typhlosion";
            break;
        case 158:
            name = "Totodile";
            break;
        case 159:
            name = "Croconaw";
            break;
        case 160:
            name = "Feraligatr";
            break;
        case 161:
            name = "Sentret";
            break;
        case 162:
            name = "Furret";
            break;
        case 163:
            name = "Hoothoot";
            break;
        case 164:
            name = "Noctowl";
            break;
        case 165:
            name = "Ledyba";
            break;
        case 166:
            name = "Ledian";
            break;
        case 167:
            name = "Spinarak";
            break;
        case 168:
            name = "Ariados";
            break;
        case 169:
            name = "Crobat";
            break;
        case 170:
            name = "Chinchou";
            break;
        case 171:
            name = "Lanturn";
            break;
        case 172:
            name = "Pichu";
            break;
        case 173:
            name = "Cleffa";
            break;
        case 174:
            name = "Igglybuff";
            break;
        case 175:
            name = "Togepi";
            break;
        case 176:
            name = "Togetic";
            break;
        case 177:
            name = "Natu";
            break;
        case 178:
            name = "Xatu";
            break;
        case 179:
            name = "Mareep";
            break;
        case 180:
            name = "Flaafy";
            break;
        case 181:
            name = "Ampharos";
            break;
        case 182:
            name = "Bellossom";
            break;
        case 183:
            name = "Marill";
            break;
        case 184:
            name = "Azumarill";
            break;
        case 185:
            name = "Sudowoodo";
            break;
        case 186:
            name = "Politoed";
            break;
        case 187:
            name = "Hoppip";
            break;
        case 188:
            name = "Skiploom";
            break;
        case 189:
            name = "Jumpluff";
            break;
        case 190:
            name = "Aipom";
            break;
        case 191:
            name = "Sunkern";
            break;
        case 192:
            name = "Sunflora";
            break;
        case 193:
            name = "Yanma";
            break;
        case 194:
            name = "Wooper";
            break;
        case 195:
            name = "Quagsire";
            break;
        case 196:
            name = "Espeon";
            break;
        case 197:
            name = "Umbreon";
            break;
        case 198:
            name = "Murkrow";
            break;
        case 199:
            name = "Slowking";
            break;
        case 200:
            name = "Misdreavus";
            break;
        case 201:
            name = "Unown";
            break;
        case 202:
            name = "Wobbuffet";
            break;
        case 203:
            name = "Girafarig";
            break;
        case 204:
            name = "Pineco";
            break;
        case 205:
            name = "Forretress";
            break;
        case 206: 
            name = "Dunsparce";
            break;
        case 207:
            name = "Gligar";
            break;
        case 208:
            name = "Steelix";
            break;
        case 209:
            name = "Snubbull";
            break;
        case 210:
            name = "Granbull";
            break;
        case 211:
            name = "Qwilfish";
            break;
        case 212:
            name = "Scizor";
            break;
        case 213:
            name = "Shuckle";
            break;
        case 214:
            name = "Heracross";
            break;
        case 215:
            name = "Sneasel";
            break;
        case 216:
            name = "Teddirusa";
            break;
        case 217:
            name = "Ursaring";
            break;
        case 218:
            name = "Slugma";
            break;
        case 219:
            name = "Magcargo";
            break;
        case 220:
            name = "Swinub";
            break;
        case 221:
            name = "Piloswine";
            break;
        case 222:
            name = "Corsola";
            break;
        case 223:
            name = "Remoraid";
            break;
        case 224:
            name = "Octillery";
            break;
        case 225:
            name = "Deliberd";
            break;
        case 226:
            name = "Mantine";
            break;
        case 227:
            name = "Skarmory";
            break;
        case 228:
            name = "Houndour";
            break;
        case 229:
            name = "Houndoom";
            break;
        case 230:
            name = "Kingdra";
            break;
        case 231:
            name = "Phanpy";
            break;
        case 232:
            name = "Donphan";
            break;
        case 233:
            name = "Porygon2";
            break;
        case 234:
            name = "Stantler";
            break;
        case 235:
            name = "Smeargle";
            break;
        case 236:
            name = "Tyrogue";
            break;
        case 237:
            name = "Hitmontop";
            break;
        case 238:
            name = "Smoochum";
            break;
        case 239:
            name = "Elekid";
            break;
        case 240:
            name = "Magby";
            break;
        case 241:
            name = "Miltank";
            break;
        case 242:
            name = "Blissey";
            break;
        case 243:
            name = "Raikou";
            break;
        case 244:
            name = "Entei";
            break;
        case 245:
            name = "Suicune";
            break;
        case 246:
            name = "Larvitar";
            break;
        case 247:
            name = "Pupitar";
            break;
        case 248:
            name = "Tyranitar";
            break;
        case 249:
            name = "Lugia";
            break;
        case 250:
            name = "Ho-oh";
            break;
        case 251:
            name = "Celebi";
            break;
        case 252:
            name = "Treecko";
            break;
        case 253:
            name = "Grovyle";
            break;
        case 254:
            name = "Sceptile";
            break;
        case 255:
            name = "Torchic";
            break;
        case 256:
            name = "Combusken";
            break;
        case 257:
            name = "Blaziken";
            break;
        case 258:
            name = "Mudkip";
            break;
        case 259:
            name = "Marshtomp";
            break;
        case 260:
            name = "Swampert";
            break;
        case 261:
            name = "Poochyena";
            break;
        case 262:
            name = "Mightyena";
            break;
        case 263:
            name = "Zigzagoon";
            break;
        case 264:
            name = "Linoone";
            break;
        case 265:
            name = "Wurmple";
            break;
        case 266:
            name = "Silcoon";
            break;
        case 267:
            name = "Beautifly";
            break;
        case 268:
            name = "Cascoon";
            break;
        case 269:
            name = "Dustox";
            break;
        case 270:
            name = "Lotad";
            break;
        case 271:
            name = "Lombre";
            break;
        case 272:
            name = "Ludicolo";
            break;
        case 273:
            name = "Seedot";
            break;
        case 274:
            name = "Nuzleaf";
            break;
        case 275:
            name = "Shiftry";
            break;
        case 276:
            name = "Taillow";
            break;
        case 277:
            name = "Swellow";
            break;
        case 278:
            name = "Wingull";
            break;
        case 279:
            name = "Pelipper";
            break;
        case 280:
            name = "Ralts";
            break;
        case 281:
            name = "Kirlia";
            break;
        case 282:
            name = "Gardevoir";
            break;
        case 283:
            name = "Surskit";
            break;
        case 284:
            name = "Masquerain";
            break;
        case 285:
            name = "Shroomish";
            break;
        case 286:
            name = "Breloom";
            break;
        case 287:
            name = "Slakoth";
            break;
        case 288:
            name = "Vigoroth";
            break;
        case 289:
            name = "Slakoth";
            break;
        case 290:
            name = "Nincada";
            break;
        case 291:
            name = "Ninjask";
            break;
        case 292:
            name = "Shedinja";
            break;
        case 293:
            name = "Whismur";
            break;
        case 294:
            name = "Loudred";
            break;
        case 295:
            name = "Exploud";
            break;
        case 296:
            name = "Makuhita";
            break;
        case 297:
            name = "Hariyama";
            break;
        case 298:
            name = "Azurill";
            break;
        case 299:
            name = "Nosepass";
            break;
        case 300:
            name = "Skitty";
            break;
        case 301:
            name = "Delcatty";
            break;
        case 302:
            name = "Sableye";
            break;
        case 303:
            name = "Mawile";
            break;
        case 304:
            name = "Aron";
            break;
        case 305:
            name = "Lairon";
            break;
        case 306:
            name = "Aggron";
            break;
        case 307:
            name = "Meditite";
            break;
        case 308:
            name = "Medicham";
            break;
        case 309:
            name = "Electrike";
            break;
        case 310:
            name = "Manectric";
            break;
        case 311:
            name = "Plusle";
            break;
        case 312:
            name = "Minun";
            break;
        case 313:
            name = "Volbeat";
            break;
        case 314:
            name = "Illumise";
            break;
        case 315:
            name = "Roselia";
            break;
        case 316:
            name = "Gulpin";
            break;
        case 317:
            name = "Swalot";
            break;
        case 318:
            name = "Carvanha";
            break;
        case 319:
            name = "Sharpedo";
            break;
        case 320:
            name = "Wailmer";
            break;
        case 321:
            name = "Wailord";
            break;
        case 322:
            name = "Numel";
            break;
        case 323:
            name = "Camerupt";
            break;
        case 324:
            name = "Torkoal";
            break;
        case 325:
            name = "Spoink";
            break;
        case 326:
            name = "Grumpig";
            break;
        case 327:
            name = "Spinda";
            break;
        case 328:
            name = "Trapinch";
            break;
        case 329:
            name = "Vibrava";
            break;
        case 330:
            name = "Flygon";
            break;
        case 331:
            name = "Cacnea";
            break;
        case 332:
            name = "Cacturne";
            break;
        case 333:
            name = "Swablu";
            break;    
        case 334:
            name = "Altaria";
            break;
        case 335:
            name = "Zangoose";
            break;
        case 336:
            name = "Seviper";
            break;
        case 337:
            name = "Lunatone";
            break;
        case 338:
            name = "Solrock";
            break;
        case 339:
            name = "Barboach";
            break;
        case 340:
            name = "Whiscash";
            break;
        case 341:
            name = "Corphish";
            break;
        case 342:
            name = "Crawdaunt";
            break;
        case 343:
            name = "Baltoy";
            break;
        case 344:
            name = "Claydol";
            break;
        case 345:
            name = "Lileep";
            break;
        case 346:
            name = "Cradily";
            break;
        case 347:
            name = "Anorith";
            break;
        case 348:
            name = "Armaldo";
            break;
        case 349:
            name = "Feebas";
            break;
        case 350:
            name = "Milotic";
            break;
        case 351:
            name = "Castform";
            break;
        case 352:
            name = "Kecleon";
            break;
        case 353:
            name = "Shuppet";
            break;
        case 354:
            name = "Banette";
            break;
        case 355:
            name = "Duskull";
            break;
        case 356:
            name = "Dusclops";
            break;
        case 357:
            name = "Tropius";
            break;
        case 358:
            name = "Chimecho";
            break;
        case 359:
            name = "Absol";
            break;
        case 360:
            name = "Wynaut";
            break;
        case 361:
            name = "Snorunt";
            break;
        case 362:
            name = "Glalie";
            break;
        case 363:
            name = "Spheal";
            break;
        case 364:
            name = "Sealo";
            break;
        case 365:
            name = "Walrein";
            break;
        case 366:
            name = "Clamperl";
            break;
        case 367:
            name = "Huntail";
            break;
        case 368:
            name = "Gorebyss";
            break;
        case 369:
            name = "Relicanth";
            break;
        case 370:
            name = "Luvdisc";
            break;
        case 371:
            name = "Bagon";
            break;
        case 372:
            name = "Shelgon";
            break;
        case 373:
            name = "Salamence";
            break;
        case 374:
            name = "Beldum";
            break;
        case 375:
            name = "Metang";
            break;
        case 376:
            name = "Metagross";
            break;
        case 377:
            name = "Regirock";
            break;
        case 378:
            name = "Regice";
            break;
        case 379:
            name = "Registeel";
            break;
        case 380:
            name = "Latias";
            break;
        case 381:
            name = "Latios";
            break;
        case 382:
            name = "Kyogre";
            break;
        case 383:
            name = "Groudon";
            break;
        case 384:
            name = "Rayquaza";
            break;
        case 385:
            name = "Jirachi";
            break;
        case 386:
            name = "Deoxys";
            break;
        case 387:
            name = "Turtwig";
            break;
        case 388:
            name = "Grotle";
            break;
        case 389:
            name = "Torterra";
            break;
        case 390:
            name = "Chimchar";
            break;
        case 391:
            name = "Monferno";
            break;
        case 392:
            name = "Infernape";
            break;
        case 393:
            name = "Piplup";
            break;
        case 394:
            name = "Prinplup";
            break;
        case 395:
            name = "Empoleon";
            break;
        case 396:
            name = "Starly";
            break;
        case 397:
            name = "Staravia";
            break;
        case 398:
            name = "Staraptor";
            break; 
        case 399:
            name = "Bidoof";
            break;
        case 400:
            name = "Bibarel";
            break;
        case 401:
            name = "Kricketot";
            break;
        case 402:
            name = "Kricketune";
            break;
        case 403:
            name = "Shinx";
            break;
        case 404:
            name = "Luxio";
            break;
        case 405:
            name = "Luxray";
            break;
        case 406:
            name = "Budew";
            break;
        case 407:
            name = "Roserade";
            break;
        case 408:
            name = "Cranidos";
            break;
        case 409:
            name = "Rampardos";
            break;
        case 410:
            name = "Shieldon";
            break;
        case 411:
            name = "Bastiodon";
            break;
        case 412:
            name = "Burmy";
            break;
        case 413:
            name = "Wormadam";
            break;
        case 414:
            name = "Mothim";
            break;
        case 415:
            name = "Combee";
            break;
        case 416:
            name = "Vespiquen";
            break;
        case 417:
            name = "Pachirisu";
            break;
        case 418:
            name = "Buizel";
            break;
        case 419:
            name = "Floatzel";
            break;
        case 420:
            name = "Cherubi";
            break;
        case 421:
            name = "Cherrim";
            break;
        case 422:
            name = "Shellos";
            break;
        case 423:
            name = "Gastrodon";
            break;
        case 424:
            name = "Ambipom";
            break;
        case 425:
            name = "Drifloon";
            break;
        case 426:
            name = "Drifblim";
            break;
        case 427:
            name = "Buneary";
            break;
        case 428:
            name = "Lopunny";
            break;
        case 429:
            name = "Mismagius";
            break;
        case 430:
            name = "Honchkrow";
            break;
        case 431:
            name = "Glameow";
            break;
        case 432:
            name = "Purugly";
            break;
        case 433:
            name = "Chingling";
            break;
        case 434:
            name = "Stunky";
            break;
        case 435:
            name = "Skuntank";
            break;
        case 436:
            name = "Bronzor";
            break;
        case 437:
            name = "Bronzong";
            break;
        case 438:
            name = "Bonsly";
            break;
        case 439:
            name = "Mime Jr.";
            break;
        case 440:
            name = "Happiny";
            break;
        case 441:
            name = "Chatot";
            break;
        case 442:
            name = "Spiritomb";
            break;
        case 443:
            name = "Gible";
            break;
        case 444:
           name = "Gabite";
           break;
        case 445:
            name = "Garchomp";
            break;
        case 446:
            name = "Munchlax";
            break;
        case 447:
            name = "Riolu";
            break;
        case 448:
            name = "Lucario";
            break;
        case 449:
            name = "Hippopotas";
            break;
        case 450:
            name = "Hippowdon";
            break;
        case 451:
            name = "Skorupi";
            break;
        case 452:
            name = "Drapion";
            break;
        case 453:
            name = "Croagunk";
            break;
        case 454:
            name = "Toxicroak";
            break;
        case 455:
            name = "Carnivine";
            break;
        case 456:
            name = "Finneon";
            break;
        case 457:
            name = "Lumineon";
            break;
        case 458:
            name = "Mantyke";
            break;
        case 459:
            name = "Snover";
            break;
        case 460:
            name = "Abomasnow";
            break;
        case 461:
            name = "Weavile";
            break;
        case 462:
            name = "Magnezone";
            break;
        case 463:
            name = "Lickilicky";
            break;
        case 464:
            name = "Rhyperior";
            break;
        case 465:
            name = "Tangrowth";
            break;
        case 466:
            name = "Electivire";
            break;
        case 467:
            name = "Magmortar";
            break;
        case 468:
            name = "Togekiss";
            break;
        case 469:
            name = "Yanmega";
            break;
        case 470:
            name = "Leafeon";
            break;
        case 471:
            name = "Glaceon";
            break;
        case 472:
            name = "Gliscor";
            break;
        case 473:
            name = "Mamoswine";
            break;
        case 474:
            name = "Porygon-Z";
            break;
        case 475:
            name = "Gallade";
            break;
        case 476:
            name = "Probopass";
            break;
        case 477:
            name = "Dusknoir";
            break;
        case 478:
            name = "Frostlass";
            break;
        case 479:
            name = "Rotom";
            break;
        case 480:
            name = "Uxie";
            break;
        case 481:
            name = "Mesprit";
            break;
        case 482:
            name = "Azelf";
            break;
        case 483:
            name = "Dialga";
            break;
        case 484:
            name = "Palkia";
            break;
        case 485:
            name = "Heatran";
            break;
        case 486:
            name = "Regigigas";
            break;
        case 487:
            name = "Giratina";
            break;
        case 488:
            name = "Cresselia";
            break;
        case 489:
            name = "Phione";
            break;
        case 490:
            name = "Manaphy";
            break;
        case 491:
            name = "Darkrai";
            break;
        case 492:
            name = "Shaymin";
            break;
        case 493:
            name = "Arceus";
            break;
        case 494:
            name = "Victini";
            break;
        case 495:
            name = "Snivy";
            break;
        case 496:
            name = "Servine";
            break;
        case 497:
            name = "Serperior";
            break;
        case 498:
            name = "Tepig";
            break;
        case 499:
            name = "Pignite";
            break;
        case 500:
            name = "Emboar";
            break;
        case 501:
            name = "Oshawott";
            break;
        case 502:
            name = "Dewott";
            break;
        case 503:
            name = "Samurott";
            break;
        case 504:
            name = "Patrat";
            break;
        case 505:
            name = "Watchog";
            break;
        case 506:
            name = "Lilipup";
            break;
        case 507:
            name = "Herdier";
            break;
        case 508:
            name = "Stoutland";
            break;
        case 509:
            name = "Purrloin";
            break;
        case 510:
            name = "Liepard";
            break;
        case 511:
            name = "Pansage";
            break;
        case 512:
            name = "Simisage";
            break;
        case 513:
            name = "Pansear";
            break;
        case 514:
            name = "Simisear";
            break;
        case 515:
            name = "Panpour";
            break;
        case 516:
            name = "Simipour";
            break;
        case 517:
            name = "Munna";
            break;
        case 518:
            name = "Musharna";
            break;
        case 519:
            name = "Pidove";
            break;
        case 520:
            name = "Tranquill";
            break;
        case 521:
            name = "Unfezant";
            break;
        case 522:
            name = "Blitzle";
            break;
        case 523:
            name = "Zebstrika";
            break;
        case 524:
            name = "Roggenrola";
            break;
        case 525:
            name = "Boldore";
            break;
        case 526:
            name = "Gigalith";
            break;
        case 527:
            name = "Woobat";
            break;
        case 528:
            name = "Swoobat";
            break;
        case 529:
            name = "Drilbur";
            break;
        case 530:
            name = "Excadrill";
            break;
        case 531:
            name = "Audino";
            break;
        case 532:
            name = "Timburr";
            break;
        case 533:
            name = "Gurdurr";
            break;
        case 534:
            name = "Conkeldurr";
            break;
        case 535:
            name = "Tympole";
            break;
        case 536:
            name = "Palpitoad";
            break;
        case 537:
            name = "Sesmitoad";
            break;
        case 538:
            name = "Throh";
            break;
        case 539:
            name = "Sawk";
            break;
        case 540:
            name = "Sewaddle";
            break;
        case 541:
            name = "Swadloon";
            break;
        case 542:
            name = "Leavanny";
            break;
        case 543:
            name = "Venipede";
            break;
        case 544:
            name = "Whirlipede";
            break;
        case 545:
            name = "Scolipede";
            break;
        case 546:
            name = "Cottonee";
            break;
        case 547:
            name = "Whimsicott";
            break;
        case 548:
            name = "Petilil";
            break;
        case 549:
            name = "Lilligant";
            break;
        case 550:
            name = "Basculin";
            break;
        case 551:
            name = "Sandile";
            break;
        case 552:
            name = "Krokorok";
            break;
        case 553:
            name = "Krookodile";
            break;
        case 554:
            name = "Darumaka";
            break;
        case 555:
            name = "Darmanitan";
            break;
        case 556:
            name = "Maractus";
            break;
        case 557:
            name = "Dwebble";
            break;
        case 558:
            name = "Crustle";
            break;
        case 559:
            name = "Scraggy";
            break;
        case 560:
            name = "Scrafty";
            break;
        case 561:
            name = "Sigilyph";
            break;
        case 562:
            name = "Yamask";
            break;
        case 563:
            name = "Cofagrigus";
            break;
        case 564:
            name = "Tirtouga";
            break;
        case 565:
            name = "Carracosta";
            break;
        case 566:
            name = "Archen";
            break;
        case 567:
            name = "Archeops";
            break;
        case 568:
            name = "Trubbish";
            break;
        case 569:
            name = "Garbodor";
            break;
        case 570:
            name = "Zorua";
            break;
        case 571:
            name = "Zoroark";
            break;
        case 572:
            name = "Minccino";
            break;
        case 573:
            name = "Cinccino";
            break;
        case 574:
            name = "Gothita";
            break;
        case 575:
            name = "Gothorita";
            break;
        case 576:
            name = "Gothitelle";
            break;
        case 577:
            name = "Solosis";
            break;
        case 578:
            name = "Duosion";
            break;
        case 579:
            name = "Reuniclus";
            break;
        case 580:
            name = "Ducklett";
            break;
        case 581:
            name = "Swanna";
            break;
        case 582:
            name = "Vanillite";
            break;
        case 583:
            name = "Vanillish";
            break;
        case 584:
            name = "Vanilluxe";
            break;
        case 585:
            name = "Deerling";
            break;
        case 586:
            name = "Sawsbuck";
            break;
        case 587:
            name = "Emolga";
            break;
        case 588:
            name = "Karrablast";
            break;
        case 589:
            name = "Escavalier";
            break;
        case 590:
            name = "Foongus";
            break;
        case 591:
            name = "Amoongus";
            break;
        case 592:
            name = "Frillish";
            break;
        case 593:
            name = "Jellicent";
            break;
        case 594:
            name = "Alomomola";
            break;
        case 595:
            name = "Joltik";
            break;
        case 596:
            name = "Galvantula";
            break;
        case 597:
            name = "Ferroseed";
            break;
        case 598:
            name = "Ferrothorn";
            break;
        case 599:
            name = "Klink";
            break;
        case 600:
            name = "Klang";
            break;
        case 601:
            name = "Klinklang";
            break;
        case 602:
            name = "Tynamo";
            break;
        case 603:
            name = "Elektrik";
            break;
        case 604:
            name = "Elektross";
            break;
        case 605:
            name = "Elgyem";
            break;
        case 606:
            name = "Beeheeyem";
            break;
        case 607:
            name = "Litwick";
            break;
        case 608:
            name = "Lampent";
            break;
        case 609:
            name = "Chandelure";
            break;
        case 610:
            name = "Axew";
            break;
        case 611:
            name = "Fraxure";
            break;
        case 612:
            name = "Haxorus";
            break;
        case 613:
            name = "Cubchoo";
            break;
        case 614:
            name = "Beartic";
            break;
        case 615:
            name = "Cryogonal";
            break;
        case 616:
            name = "Shelmet";
            break;
        case 617:
            name = "Accelgor";
            break;
        case 618:
            name = "Stunfisk";
            break;
        case 619:
            name = "Mienfoo";
            break;
        case 620:
            name = "Mienshao";
            break;
        case 621:
            name = "Druddigon";
            break;
        case 622:
            name = "Golett";
            break;
        case 623:
            name = "Golurk";
            break;
        case 624:
            name = "Pawniard";
            break;
        case 625:
            name = "Bisharp";
            break;
        case 626:
            name = "Bouffalant";
            break;
        case 627:
            name = "Rufflet";
            break;
        case 628:
            name = "Braviary";
            break;
        case 629:
            name = "Vullaby";
            break;
        case 630:
            name = "Mandibuzz";
            break;
        case 631:
            name = "Heatmor";
            break;
        case 632:
            name = "Durant";
            break;
        case 633:
            name = "Deino";
            break;
        case 634:
            name = "Zweilous";
            break;
        case 635:
            name = "Hydriegon";
            break;
        case 636:
            name = "Larvesta";
            break;
        case 637:
            name = "Volcarona";
            break;
        case 638:
            name = "Coballion";
            break;
        case 639:
            name = "Terrakion";
            break;
        case 640:
            name = "Virizion";
            break;
        case 641:
            name = "Tornadus";
            break;
        case 642:
            name = "Thundurus";
            break;
        case 643:
            name = "Reshiram";
            break;
        case 644:
            name = "Zekrom";
            break;
        case 645:
            name = "Landorus";
            break;
        case 646:
            name = "Kyurem";
            break;
        case 647:
            name = "Keldeo";
            break;
        case 648:
            name = "Meloetta";
            break;
        case 649:
            name = "Genesect";
            break;
        case 650:
            name = "Chespin";
            break;
        case 651:
            name = "Quilladin";
            break;
        case 652:
            name = "Chesnaught";
            break;
        case 653:
            name = "Fennekin";
            break;
        case 654:
            name = "Braixen";
            break;
        case 655:
            name = "Delphox";
            break;
        case 656:
            name = "Froakie";
            break;
        case 657:
            name = "Frogadier";
            break;
        case 658:
            name = "Greninja";
            break;
        case 659:
            name = "Bunnelby";
            break;
        case 660:
            name = "Diggersby";
            break;
        case 661:
            name = "Fletchling";
            break;
        case 662:
            name = "Fletchinder";
            break;
        case 663:
            name = "Talonflame";
            break;
        case 664:
            name = "Scatterbug";
            break;
        case 665:
            name = "Spewpa";
            break;
        case 666:
            name = "Vivillon";
            break;
        case 667:
            name = "Litleo";
            break;
        case 668:
            name = "Pyroar";
            break;
        case 669:
            name = "Flabébé";
            break;
        case 670:
            name = "Floette";
            break;
        case 671:
            name = "Florges";
            break;
        case 672:
            name = "Skiddo";
            break;
        case 673:
            name = "Gogoat";
            break;
        case 674:
            name = "Pancham";
            break;
        case 675:
            name = "Pangoro";
            break;
        case 676:
            name = "Furfrou";
            break;
        case 677:
            name = "Espurr";
            break;
        case 678:
            name = "Meowstic";
            break;
        case 679:
            name = "Honedge";
            break;
        case 680:
            name = "Doublade";
            break;
        case 681:
            name = "Aegislash";
            break;
        case 682:
            name = "Spritzee";
            break;
        case 683:
            name = "Aromatisse";
            break;
        case 684:
            name = "Swirlix";
            break;
        case 685:
            name = "Slurpuff";
            break;
        case 686:
            name = "Inkay";
            break;
        case 687:
            name = "Malamar";
            break;
        case 688:
            name = "Binacle";
            break;
        case 689:
            name = "Barbaracle";
            break;
        case 690:
            name = "Skrelp";
            break;
        case 691:
            name = "Dragalge";
            break;
        case 692:
            name = "Clauncher";
            break;
        case 693:
            name = "Clawitzer";
            break;
        case 694:
            name = "Helioptile";
            break;
        case 695:
            name = "Heliolisk";
            break;
        case 696:
            name = "Tyrunt";
            break;
        case 697:
            name = "Tyrantrum";
            break;
        case 698:
            name = "Amaura";
            break;
        case 699:
            name = "Aurorus";
            break;
        case 700:
            name = "Sylveon";
            break;
        case 701:
            name = "Hawlucha";
            break;
        case 702:
            name = "Dedenne";
            break;
        case 703:
            name = "Carbink";
            break;
        case 704:
            name = "Goomy";
            break;
        case 705:
            name = "Sligoo";
            break;
        case 706:
            name = "Goodra";
            break;
        case 707:
            name = "Klefki";
            break;
        case 708:
            name = "Phantump";
            break;
        case 709:
            name = "Trevenant";
            break;
        case 710:
            name = "Pumpkaboo";
            break;
        case 711:
            name = "Gourgeist";
            break;
        case 712:
            name = "Bergmite";
            break;
        case 713:
            name = "Avalugg";
            break;
        case 714:
            name = "Noibat";
            break;
        case 715:
            name = "Noivern";
            break;
        case 716:
            name = "Xerneas";
            break;
        case 717:
            name = "Yveltal";
            break;
        case 718:
            name = "Zygarde";
            break;
        case 719:
            name = "Diancie";
            break;
        case 720:
            name = "Volcanion";
            break;
        case 721:
            name = "Hoopa";
            break;   
        }
    return name;
    }
    private static double generateCatchRate(){
        switch(dexNum){
            case 10:
            case 13:
            case 16:
            case 19:
            case 21:
            case 23:
            case 27:
            case 41:
            case 43:
            case 50:
            case 52:
            case 60:
            case 69:
            case 74:
            case 129:
            case 161:
            case 163:
            case 165:
            case 167:
            case 187:
            case 194:
            case 261:
            case 263:
            case 265:
            case 270:
            case 273:
            case 285:
            case 287:
            case 290:
            case 299:
            case 300:
            case 322:
            case 325:
            case 327:
            case 328:
            case 333:
            case 343:
            case 349:
            case 363:
            case 366:
            case 396:
            case 399:
            case 401:
            case 406:
            case 436:
            case 438:
            case 504:
            case 505:
            case 506:
            case 509:
            case 519:
            case 524:
            case 531:
            case 535:
            case 540:
            case 543:
            case 556:
            case 572:
            case 582:
            case 597:
            case 605:
            case 659:
            case 661:
            case 664:
                catchRate = 255;
                break;
            case 29:		
            case 32:		
            case 179:			
            case 191:		
            case 280:			
            case 403:
                catchRate = 235;
                break;
            case 98:			
            case 116:			
            case 118:		
            case 120:			
            case 201:			
            case 220:			
            case 316:			
            case 318:		
            case 353:		
            case 370:		
            case 434:			
            case 669:	
            case 690:			
            case 692:
                catchRate = 225;
                break;
            case 667:			
            case 674:
                catchRate = 220;
                break;
            case 341:
                catchRate = 205;
            case 63:			
            case 276:		
            case 283:		
            case 297:		
            case 311:			
            case 312:			
            case 352:		
            case 357:		
            case 417:		
            case 455:		
            case 574:		
            case 577:		
            case 587:			
            case 588:		
            case 616:		
            case 672:			
            case 682:		
            case 684:
                catchRate = 200;
                break;
            case 25:		
            case 37:			
            case 46:			
            case 48:		
            case 54:		
            case 56:			
            case 58:		
            case 72:		
            case 77:			
            case 79:		
            case 81:		
            case 84:			
            case 86:			
            case 88:			
            case 90:		
            case 92:			
            case 96:		
            case 100:		
            case 104:			
            case 109:		
            case 170:		
            case 172:			
            case 175:			
            case 177:			
            case 183:			
            case 204:			
            case 206:		
            case 209:		
            case 213:		
            case 218:			
            case 223:		
            case 278:		
            case 293:		
            case 331:			
            case 339:		
            case 355:		
            case 361:		
            case 418:			
            case 420:		
            case 422:		
            case 427:		
            case 431:		
            case 456:		
            case 517:			
            case 522:		
            case 527:			
            case 546:		
            case 548:		
            case 557:		
            case 562:			
            case 568:		
            case 580:		
            case 585:		
            case 590:		
            case 592:		
            case 595:			
            case 602:			
            case 607:		
            case 622:			
            case 627:		
            case 629:		
            case 677:			
            case 686:			
            case 694:		
            case 712:		
            case 714:
                catchRate = 190;
                break;
            case 66:			
            case 296:		
            case 304:			
            case 307:		
            case 532:		
            case 551:		
            case 559:		
            case 619:		
            case 679:	
                catchRate = 180;
                break;
            case 39:		
            case 174:
                catchRate = 170;
                break;
            case 676:
                catchRate = 160;
                break;
            case 342:
                catchRate = 155;
                break;
            case 35:		
            case 173:			
            case 298:		
            case 313:		
            case 314:		
            case 315:		
            case 323:
                catchRate = 150;
                break;
            case 439:
                catchRate = 145;
                break;
            case 449:		
            case 453:		
            case 683:		
            case 685: 
                catchRate = 140;
                break;
            case 440:		
            case 599:    
                catchRate = 130;
                break;
            case 20:		
            case 262:		
            case 400:		
            case 660:
                catchRate = 127;
                break;
            case 320:		
            case 360:			
            case 425:
                catchRate = 125;
                break;
            case 11:		
            case 14:			
            case 17:		
            case 30:		
            case 33:		
            case 44:			
            case 61:		
            case 70:		
            case 75:		
            case 111:		
            case 180:		
            case 188:		
            case 192:		
            case 216:		
            case 228:		
            case 231:			
            case 266:		
            case 268:		
            case 271:			
            case 274:		
            case 281:			
            case 288:		
            case 291:		
            case 294:		
            case 309:		
            case 329:		
            case 364:			
            case 397:		
            case 404:			
            case 412:			
            case 415:			
            case 433:		
            case 451:		
            case 459:			
            case 507:		
            case 520:		
            case 525:		
            case 529:		
            case 536:		
            case 541:		
            case 544:		
            case 554:		
            case 583:		
            case 613:		
            case 624:		
            case 662:		
            case 665:			
            case 670:		
            case 688:		
            case 708:		
            case 710:
                catchRate = 120;
                break;
            case 64:		
            case 442:		
            case 575:		
            case 578:		
            case 701:		
            case 702:
                catchRate = 100;
                break;
            case 22:			
            case 24:			
            case 28:		
            case 42:			
            case 53:		
            case 67:		
            case 93:		
            case 102:		
            case 162:			
            case 164:		
            case 166:			
            case 168:		
            case 169:			
            case 195:		
            case 264:		
            case 286:		
            case 305:			
            case 308:		
            case 324:		
            case 335:		
            case 336:		
            case 344:		
            case 356:		
            case 437:		
            case 510:		
            case 533:		
            case 552:		
            case 560:		
            case 563:		
            case 598:		
            case 606:		
            case 608:		
            case 623:			
            case 631:		
            case 632:			
            case 680: 
                catchRate = 90;
                break;
            case 687:
                catchRate = 80;
                break;
            case 26:			
            case 38:		
            case 47:		
            case 49:		
            case 55:		
            case 57:		
            case 59:		
            case 80:		
            case 87:		
            case 89:			
            case 97:			
            case 105:		
            case 117:			
            case 171:		
            case 176:		
            case 178:			
            case 184:		
            case 193:			
            case 205:		
            case 210:		
            case 219:		
            case 221:		
            case 224:		
            case 236:		
            case 284:		
            case 317:			
            case 340:		
            case 362:			
            case 407:		
            case 419:		
            case 421:		
            case 423:		
            case 432:		
            case 447:			
            case 454:		
            case 457:		
            case 478:		
            case 518:		
            case 523:		
            case 547:		
            case 549:		
            case 558:		
            case 570:			
            case 586:		
            case 589:		
            case 591:		
            case 594:		
            case 596:		
            case 610:			
            case 617:		
            case 618:		
            case 678:		
            case 695:		
            case 707: 
                catchRate = 75;
                break;
            case 199:
                catchRate = 199;
                break;
            case 185:		
            case 511:		
            case 512:		
            case 513:		
            case 514:		
            case 515:		
            case 516:		
            case 668:    
            case 675:
                catchRate = 65;
                break;
            case 73:		
            case 78:		
            case 82:		
            case 91:		
            case 99:		
            case 101:		
            case 110:		
            case 112:			
            case 119:		
            case 121:		
            case 203:		
            case 207:			
            case 215:		
            case 217:		
            case 222:		
            case 232:		
            case 301:		
            case 319:		
            case 321:		
            case 326:		
            case 332:		
            case 350:		
            case 367:		
            case 368:		
            case 426:		
            case 428:		
            case 435:		
            case 450:		
            case 460:		
            case 476:		
            case 530:		
            case 555:		
            case 569:		
            case 573:		
            case 593:		
            case 600:			
            case 603:		
            case 611:		
            case 614:		
            case 628:		
            case 630:		
            case 703:		
            case 709:		
            case 711:
                catchRate = 60;
                break;
            case 691:		
            case 693:		
            case 713:
                catchRate = 55;
                break;
            case 40:		
            case 51:		
            case 65:		
            case 446:		
            case 473:		
            case 576:		
            case 579:
                catchRate = 50;
                break;
            case 1:		
            case 2:		
            case 3:		
            case 4:		
            case 5:		
            case 6:		
            case 7:		
            case 8:		
            case 9:		
            case 12:		
            case 15:		
            case 18:		
            case 31:		
            case 34:		
            case 45:		
            case 62:		
            case 68:		
            case 71:		
            case 76:			
            case 83:		
            case 85:			
            case 94:			
            case 95:			
            case 103:		
            case 106:		
            case 107:		
            case 108:		
            case 114:		
            case 115:		
            case 122:	
            case 123:		
            case 124:			
            case 125:		
            case 126:			
            case 127:			
            case 128:			
            case 130:		
            case 131:			
            case 133:			
            case 134:		
            case 135:		
            case 136:		
            case 137:		
            case 138:		
            case 139:		
            case 140:			
            case 141:		
            case 142:		
            case 147:		
            case 148:		
            case 149:		
            case 151:			
            case 152:		
            case 153:		
            case 154:		
            case 155:		
            case 156:		
            case 157:		
            case 158:		
            case 159:		
            case 160:		
            case 181:		
            case 182:		
            case 186:		
            case 189:		
            case 190:			
            case 196:			
            case 197:		
            case 200:		
            case 202:		
            case 211:		
            case 214:		
            case 225:		
            case 229:		
            case 230:		
            case 233:		
            case 234:		
            case 235:		
            case 237:		
            case 238:		
            case 239:			
            case 240:			
            case 241:		
            case 246:		
            case 247:		
            case 248:		
            case 251:			
            case 252:		
            case 253:		
            case 254:		
            case 255:		
            case 256:		
            case 257:		
            case 258:			
            case 259:		
            case 260:		
            case 267:		
            case 269:			
            case 272:		
            case 275:		
            case 277:		
            case 279:		
            case 282:		
            case 289:		
            case 292:		
            case 295:		
            case 302:		
            case 303:			
            case 306:			
            case 310:		
            case 330:			
            case 334:		
            case 337:		
            case 338:		
            case 345:			
            case 346:		
            case 347:		
            case 348:		
            case 351:		
            case 354:		
            case 358:		
            case 365:		
            case 371:			
            case 372:		
            case 373:		
            case 387:		
            case 388:			
            case 389:		
            case 390:		
            case 391:		
            case 392:		
            case 393:			
            case 394:		
            case 395:		
            case 398:		
            case 402:		
            case 405:			
            case 408:		
            case 409:		
            case 410:		
            case 411:		
            case 413:		
            case 414:			
            case 416:		
            case 424:		
            case 429:		
            case 443:			
            case 444:			
            case 445:		
            case 448:		
            case 452:		
            case 461:		
            case 470:		
            case 471:		
            case 475:		
            case 477:		
            case 479:			
            case 492:		
            case 495:			
            case 496:		
            case 497:		
            case 498:			
            case 499:		
            case 500:			
            case 501:		
            case 502:			
            case 503:		
            case 508:		
            case 521:		
            case 526:		
            case 528:		
            case 534:		
            case 537:		
            case 538:			
            case 539:			
            case 542:		
            case 545:		
            case 553:		
            case 561:		
            case 564:		
            case 565:		
            case 566:			
            case 567:		
            case 571:		
            case 581:			
            case 584:		
            case 609:		
            case 612:		
            case 620:		
            case 621:		
            case 625:		
            case 626:		
            case 633:			
            case 634:		
            case 635:		
            case 636:		
            case 643:		
            case 644:			
            case 650:		
            case 651:		
            case 652:		
            case 653:		
            case 654:		
            case 655:		
            case 656:		
            case 657:		
            case 658:		
            case 663:		
            case 666:		
            case 671:		
            case 673:			
            case 681:		
            case 689:		
            case 696:			
            case 697:		
            case 698:			
            case 699:		
            case 700:		
            case 704:			
            case 705:		
            case 706:			
            case 715:		
            case 716:		
            case 717:    
                catchRate = 45;
                break;
            case 132:
                catchRate = 35;
                break;
            case 113:		
            case 198:		
            case 242:		
            case 359:			
            case 430:		
            case 441:			
            case 462:		
            case 463:		
            case 464:		
            case 465:		
            case 466:		
            case 467:		
            case 468:		
            case 469:		
            case 472:		
            case 474:		
            case 483:			
            case 484:			
            case 489:			
            case 601:		
            case 604:
                catchRate = 30;
                break;
            case 36:		
            case 143:		
            case 208:		
            case 212:			
            case 226:		
            case 227:		
            case 369:		
            case 458:		
            case 550:		
            case 615:  
                catchRate = 25;
                break;
            case 637:
                catchRate = 15;
                break;
            case 382:			
            case 383:
                catchRate = 5;
                break;
            case 144:		
            case 145:			
            case 146:		
            case 150:			
            case 243:			
            case 244:			
            case 245:		
            case 249:			
            case 250:	
            case 374:			
            case 375:			
            case 376:		
            case 377:		
            case 378:			
            case 379:		
            case 380:			
            case 381:			
            case 384:		
            case 385:		
            case 386:			
            case 480:			
            case 481:		
            case 482:			
            case 485:		
            case 486:		
            case 487:		
            case 488:		
            case 490:		
            case 491:		
            case 493:			
            case 494:		
            case 638:		
            case 639:		
            case 640:		
            case 641:		
            case 642:		
            case 645:		
            case 646:			
            case 647:			
            case 648:		
            case 649:		
            case 718:		
            case 719:
            case 720:
            case 721:
                catchRate = 3;
        }
        return catchRate;
    }
}
