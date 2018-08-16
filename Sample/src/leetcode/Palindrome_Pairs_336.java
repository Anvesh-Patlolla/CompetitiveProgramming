package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
//TODO: incomplete. Logic is easy.
public class Palindrome_Pairs_336 {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> retList = new ArrayList<>();
		HashMap<String, Integer> wordSet = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			wordSet.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			
		}
		return retList;
	}

	private boolean equals(String string, String string2) {
		char[] concat = ArrayUtils.addAll(string.toCharArray(), string2.toCharArray());
		for (int i = 0, j = concat.length - 1; i < concat.length; i++, j--) {
			if (concat[i] != concat[j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Palindrome_Pairs_336 obj = new Palindrome_Pairs_336();
		String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
		System.out.println(obj.palindromePairs(words));
		String words2[] = { "c", "ijefjehefbeabhhhaadf", "jjagh", "jgffdcedgi", "d", "bhgdfcdcghb", "dfhajahiajffe",
				"jjdcjbjgbbjjb", "hdfhfcaeiiejaih", "ejheghchjdfdi", "ifedbjgigcfai", "jhbcjj", "ehiggi", "i", "dcbhc",
				"bafccbabge", "ejechhdcaecadiaei", "jaigade", "gaggihi", "jajaj", "dhijc", "j", "ifeajhj", "icg",
				"gdhhedbehbdbefgeaghd", "fbhdagdcgfabbbedeh", "cajebjeifchbcfghihhc", "hbfgehece", "jdfgajbicgaaj",
				"bfhca", "egfb", "gbheieahcbhcijchf", "ggghegajhciae", "ahhiagjfgecjbfaaibce", "eeedgba", "fceegjjdi",
				"hjdeehhddbbjdfhga", "fag", "fdedgehj", "ifdbdibbdhaa", "hedebdicffhigajh", "dddef", "gdgefgdaiccbdhc",
				"afbigedbga", "fdcdc", "haidijbcefgcehgch", "bdbegcfehbdjfi", "eahcbhjd", "fdhifigghfffg", "bicgi",
				"fbgfica", "gi", "cfiiicbgjhbihb", "hdad", "igfefdahdedebfh", "dbgcfcdfgaieiegfic", "adjeibihjiii",
				"echibfjjgdbgge", "h", "egb", "jfgbebggdcjjhjebj", "ag", "fd", "dfaajidiejca", "ecjijbcihafcbc",
				"bfaddg", "gdcbgfecfegahfeggigh", "gc", "iadaahghcdff", "fhfecefiadbhggad", "dadiacegbffdj",
				"egidaehijefg", "bfeifdjhcffdgcgb", "dabeffefgb", "iah", "fcfcgegjiacdgc", "gdafcdigef",
				"cfbbddafifjjjaij", "bi", "dhdbfihh", "djaeiafgcaabiedcdg", "fbe", "aagaaaf", "beafdhghhdceifbi",
				"cicigaabghgdjj", "febaebhaeebj", "acahcjjegibgg", "dedjbfjhfjagcfaie", "cfecgdecdedbeghjdjj",
				"abjaeaejie", "egeajchd", "defihd", "bjg", "eceachhed", "aeihjjffbjfdihdcigg", "fghgjabih",
				"djfcibdeaecbcdigahf", "eeaeacbifcfcb", "ihfffgaahjbfgaijf", "afcicff", "fjgihbghjgjcg",
				"biaiigjbaahaejgi", "jajhjeacieg", "aabjgahadheebe", "cjdgaeidhjhcehahd", "cgcgafgcdga",
				"jfabcfjifjabdafhh", "dhchjcj", "fj", "cddhjbdg", "cgbcc", "dhbicdhghdihbii", "addjadabdecchaahdhj",
				"bjeehfbihjacdj", "iiehebdccdcfajhff", "ahdcjecjfhebaigf", "fh", "hf", "idhachdcccea", "ijhgjhegegehch",
				"ajaajeeicdigjgh", "edeadfbbc", "ech", "hif", "bjdghdhfjefghbdaece", "diidbiafg", "aaahagibbhjgjahddg",
				"agdjhbh", "djbjgghhjijffiefi", "jajihdgecajhibfbj", "daf", "igdcdfeiaeiieifegi",
				"diaaghjfdjiffijechac", "da", "edfdaebaibaijaaj", "igcbaijca", "bebgifdbjdfdd", "gjgjghccgca",
				"deaiehhhihgf", "ib", "cajddibhiiibjaibjff", "hhgfbebececcedcbfha", "cdcbgaeefeejabbhbg",
				"ajhbhcjabcbegb", "gfgjeiihhdhhah", "bicfiigahciecedigicc", "di", "fgaeeicgb", "hgahdcgdeefgc",
				"gcgche", "eiheib", "dgejdcjegdb", "baeheiij", "ibdbjfjhhgicjijibi", "bijdceh", "hiaffag",
				"iegejfjjhgabbbdgg", "jdbgigjfhhddi", "fjcaedecfihfhfca", "giehgf", "gfe", "aiebfdfcgfacjcebij",
				"ghedibbiecbebccfbefe", "fjgihjgcafdaddje", "g", "dfeechbfdhjebddd", "jheefdagd", "jigaehiehcfd",
				"gbacidgfcgcabgjhjb", "ajcegadgcagaejfjjhdd", "faceehfdeebbigbhg", "agheegaeifagjcbjjejc",
				"fhcgidcjaeahcfbcdaij", "bhajejbgcij", "bbbe", "dijfacge", "hbigdhbbeijdjgadig", "iiecieaabfeghdc",
				"dhbaicdgfb", "hdijibehjif", "hgfffhdejddgjffaff", "fc", "ica", "hhegihidgbcijjbij",
				"ibeffhhchfdebdfca", "aagiedadddhdejajb", "bffbcifiibjcbfd", "fjjjhdhjefijheafgbf", "iahiigcidaf",
				"iecfccihiibbddiabhj", "hg", "fggihgaedaaiifhhfeh", "eegfjhg", "gajia", "bdia", "iefffagahgi",
				"igeeafdibegijicjc", "bf", "eedajefffggbedigehhb", "djedahdefbgdfghj", "ghibjddbbbggdfeihedb",
				"ihghjgjecacjg", "fgheicgeifafidfga", "a", "eah", "jccbbbicaaddefj", "afaififfdaaihbdj",
				"iffcccfadiabjddef", "ahffchhagfjjabci", "jjfajdgjddddhhebc", "cjchc", "aiahhaf", "gjbbcbh",
				"ggfafdehggeh", "bd", "ibcjhiebhhbahdcefbj", "dg", "abiedhhjeg", "hbbd", "bg", "faeffciccebjjfhdd", "b",
				"iiabhjajc", "aideadfigcdcacfg", "affefjdjgibcecdjchbg", "jibgigfgfdeabcbhdd", "fi", "eeeh",
				"dhchhdgcdechi", "fibbbhaiij", "afijbehgbhffbjbgbhf", "cgcibfhhe", "befdjd", "ahccghahfeeb",
				"bigabeaaaebiebdbfgch", "eheiib", "iedccjgajehh", "fjfjjdbiihcidjddb", "ed", "ibjcdb", "ffabbj",
				"gbhhbabcbbaieahgj", "cededb", "chhhidfcaifjigi", "eabfjbihfdhiabffg", "hec", "bfcfdfgbhf",
				"dbfidjeiga", "cbgccgadg", "difhaijhbgbeciaabi", "caiiffdagijgdaachije", "fabcjcibbgb", "hfcbhahcdccfj",
				"echfjgiedehg", "geicejjdhfbchd", "bfe", "f", "jcfbjecjaj", "ifdh", "aiijhifb", "ch", "afcbehh",
				"bchffh", "cdeh", "fhijgej", "fiaa", "fijfgcdcaajheaa", "baggdffjfjaf", "jgbeajajaidicb",
				"hcjhfdggehcagjddbic", "ijach", "ibgcgcahdaijde", "aebaijhcj", "dhjgahieddcf", "ehfjacabdge", "fhjj",
				"gjheaahbbjed", "hegahifhecegai", "caehiibff", "ffehhjaajhh", "cfd", "bihjjeijaghac", "hffejhjeadjidgj",
				"chdfihdfa", "dghj", "jfhb", "cbecjhgcc", "gbhaibedghjjfi", "eh", "jjcaj", "jjbjdhgeicadjja",
				"ahaehidba", "jdaaigfdcahigdf", "ieihejahabgacc", "iggdbfecbgcjf", "idgeheeaedgbf",
				"fbgdgefecjbbbdbhhbh", "fda", "cifiibfhdfcjaicddhij", "hcfdhhbchdcaje", "dgeacjeaigjgbegjbfhi", "hd",
				"cchgeffaiceidiibb", "eebfjgabcfchc", "dfabfdjj", "feeifi", "edjggfaf", "cgddaddfhheijcf", "fdefgca",
				"fhcj", "dddahjghiejijccdaf", "hgcighbbj", "biigbgcijgfibja", "bcghjdhabbffijdhddcf", "jedhc",
				"feddacadhcjecacg", "bejfdjegfcfjjacjhcc", "bbcbhcfj", "ehibfiieicecjehj", "bahgeihcbacj", "gcfa",
				"igd", "ahfhfgdf", "jhdj", "cgad", "acjccffggjbdgdbj", "fddidiacecdbjhc", "eifeifiiecdcbdfbc",
				"ejddjadgehjhia", "hcifdjhac", "edffjcfjhiaidffhf", "eac", "he", "fdjeb", "fibhjbaeghecdgjbdfc",
				"fbeeccecaegaiaebhija", "hehigdcegeigi", "ijgfiibchddb", "jgi", "diebbchbfcjdbiigajdd",
				"ifabigaiijaaiccc", "hhgjbcaeahgbei", "ghjjghbheghjjb", "jdjhaaedbgabcgcb", "ibh", "ieaecegjbjaghbjdab",
				"hfabjfbaabcjjaejiigh", "ifdjgggefeajgdaeega", "egfcdahgbeiffgdiji", "iceefiahfaej", "degjfecaaibi",
				"eihfiea", "jcgcdhbejhafiddgeghg", "cedjagdfecfd", "ieegaehejhbcgjg", "hcedcgjccajaaahfbbci",
				"ibdibeejcfjifigb", "feji", "debdbbcace", "bacj", "agdgjggfji", "ciifgjgjgacaijeffh", "gaeicjbhbfcf",
				"e", "ehcahedjbe", "ahaahacijjbi", "hbfhe", "dbjfjcagccajbeeaf", "jeigeieacdacafe", "cgcihhcjcbbh",
				"igbcccfadgach", "bjgagaceegigfecbhj", "fgbja", "iabd", "hdac", "fibaidcfhffejg", "hda", "eehbedefbgij",
				"dddiidhfhdchjgfh", "gcceccicgficigbbehee", "jfehfefhigifehhdce", "eijgdgceigieaagid",
				"hdfhiigehibffcd", "fcfdiahbccjgjfdfd", "iadedbdbafejdhhdjfe", "ggfhhdhcdbceffcehhb", "ehbhdcjjdef",
				"cgdafchffajjeidc", "iijhegfgbbcafjfahe", "ifheei", "be", "cdhbiefgj", "ihj", "ajgicgeffdfcfhfgaif",
				"gfgdbi", "jhchjgad", "hhihjaaagig", "chacdadbceacchg", "gcacijcdjfaf", "fadgccefcfhigjh", "fidbe",
				"gcch", "bgfiaicgbdgefjga", "aehjjadagibhbjbejh", "ajefhddchggjdbcfi", "bjdcgaachbjdhd",
				"affadiigjaddde", "fihhfbddfg", "eceegibdbfedidcied", "jf", "aiehabcjfiggajgbeih", "cai", "jgjj",
				"iccdhfbhj", "hebjidafffieeeggagaa", "bdfdghjgbgfbad", "fdijedba", "iccdjcc", "cbcaehdffcggggijdb",
				"hhbbfghbhjcggd", "facefacjj", "idcfhfi", "ffagfgaef", "hhaejceacgbij", "gbfbfahbghjadedijcbd", "dbi",
				"jdc", "ebjc", "jfjehdji", "ihhd", "jjdddjfiaci", "dihjaf", "ahfcagaegicfeg", "hgaaha", "diefia",
				"ajgifhfaddifigigcaje", "ccaig", "fjdgjcbiaigaad", "giabbcfbbe", "hdedfjfgiefcgahajgge", "cbeghggacgc",
				"fhebgd", "ejehac", "aifdjbidfcdeeiab", "ie", "igfdcdhffffigagheije", "hjccdj", "cdeijcjhidibifdj",
				"dgijh", "bgdifadhdhdgcjeiihe", "ddhfeejjciaeb", "debdjagbcihhccjbb", "ffbhciehjbgfhhdj",
				"dajfcacdfcfc", "bibfg", "bdhbbhaedfdaa", "aajdbddabgbh", "jdgjddf", "beiacajegggfa", "gfffbgjhe",
				"gajb", "ibhbcdje", "dfagggdcdbgifcdieih", "dcicahgadeejeigfcicj", "ai", "db", "jafhgg",
				"heidfdcgbacchejc", "hdb", "fhedhhcfgdh", "ghhjihjif", "hhbhhgji", "hgbhdccjgfjgibaigj", "heiehbhdchai",
				"ibhaeigdifcafeci", "ggcfgbibab", "hfbcejg", "hhdg", "ighdajfceaebcca", "eahab", "gadcegecefddjhajidd",
				"ecddcfbjdije", "hdjefaiagb", "eeccfieiihhihbdda", "ccgd", "ahajagjbehdabj", "bggceegi", "idih",
				"jachfgbebic", "aibidgcb", "aeagfgjgbhh", "iegjccichbh", "abhhjaeiicfhijaddij", "gaifcciggegijhhdje",
				"fagjiiaadigifjcef", "aieddcgieddbicaid", "feb", "fggbhfefjaf", "dhhcjhgjahhgbigbefb", "gcibi", "gbie",
				"hiiiefgdfca", "acjafeaiidjjibeegc", "defbgabh", "hfecfdigijaid", "jbighafhghgfifbhajfj", "deibaajif",
				"fehccjeded", "ffedcjdfjaeabg", "hjdbbjjfcjiadefbbfej", "dfe", "agehi", "dadc", "jdhhcfcbbgd",
				"ejahicjb", "abfcjjhgcjbhbgie", "dcicidgigd", "aifhejbfffciheheaae", "daeabaifjhiidbge", "eaid",
				"aifeeh", "gbiefcfjhghgfhgje", "fjchjjefhe", "fdeeeeh", "daefhifd", "jhbedfffgjcgaaecej",
				"dccddhdhjhdcbjecg", "egfagbhifbchjjaejibi", "fiefaagabdgabghic", "ahifeijihjcghf", "dgjaiibfi",
				"jgijhf", "jigfceajghf", "afceaj", "djiaidaggbgaegbb", "cceagfffdg", "jfccgjdhjgag",
				"fcfhfahgefjfcijjdie", "gdjagcgjdhijjdi", "badfdfeeeaji", "hbidiagabdafhdf", "fejdafbciabf",
				"ffidgbhihieeh", "cjihdjchdchjjiigcbg", "bifjfijjbagdda", "cjccbjeigfjchdjjdf", "igigaacdcgcid",
				"jidjcahbi", "jiheeedeaibbje", "iace", "ijhifdibcfjdjhddecif", "jjgfedjgeieecfi", "aiggcdhfbdcc",
				"iadfejbghbfdffi", "eb", "cjjeghjjcjg", "hbdgjee", "dhdbccgffddhgbh", "hgjhcec", "bcgjee",
				"cfgigigjahdcaa", "ahhbgg", "eedhjfjb", "diihgfbegadb", "jhdedaijbjgjbdbfj", "fhgfg", "ieahdbafghe",
				"bdbh", "dghbibbeijfji", "adbhcjijahejchabehbg", "gigbj", "agechc", "jaegffbegidgbbfhchj", "aecjb",
				"bghjbbabbjhhgfabhhj", "ehhhh", "eahdefegejejhihhichi", "iegbjbigejhgcgd", "idehbbfjdfeegeii",
				"acfbjdfhhcagjbhcga", "ehfh", "eadgcahgajbd", "jbidfgcecegeej", "ageg", "ifj", "cidijiebe",
				"acaaabehhcjhehjfcfc", "cehjaghfbegha", "bajieadjfcgaicijee", "aeicjfgbbeagdda", "ieijcajg", "gbehd",
				"jajedicajaecdbaaih", "hdahe", "ddbfchhicbihdaff", "ageei", "ggcah", "egcgieccejfgdjcgbc", "badhi",
				"faafebghfhgiafdaeajh", "cbhdjdaaaaffefeicd", "fciaggejbidebcfb", "eecib", "didfciihjgbgcfbe", "dfjgf",
				"gbggca", "ibggjeh", "bbahhb", "agcc", "aggfeehjcbgddaabf", "jdhafcdgbafcdgaacba", "iebchhcijbdh",
				"dbehidccibjggaegc", "df", "hjjaefefcjfb", "igfaadba", "fhgbdceegd", "iebfgbhdedbj", "jbbgdhbbfidihaie",
				"ihdcjcgbbecagg", "cbgdfjgiaajbjbjgfbif", "aajidffajfgeefd", "jjfiecafjiegadjficcf", "eeficdibd",
				"jdgeed", "cjad", "bigfbfighgijaeabfjha", "facgc", "gihhahhdfifj", "cchbdfgdbcghgfaaae",
				"aechehcfhegcedf", "jgbfdheaf", "decfjfefadi", "faha", "cgfegd", "dehcafhcgd", "gd", "bidaeibgj",
				"hgfegbjhdigibgh", "eififfabcdejj", "fcabgbcjhfaebace", "haehedbjaj", "ccibefffbbdfiifcih", "gbdgiaib",
				"fchicfhdaiahagcfhf", "hjgfdejedjhjfeed", "faiijjibbjcab", "ihbeffba", "ffbfagjhegjfbgjedff", "ihagb" };
		System.out.println(obj.palindromePairs(words2));
	}
}
