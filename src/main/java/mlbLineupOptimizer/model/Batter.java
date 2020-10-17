package mlbLineupOptimizer.model;

public class Batter {

    private String position;
    private String name;
    private String url;
    private String age;
    private String g;
    private String pa;
    private String ab;
    private String r;
    private String h;
    private String doubles;
    private String triples;
    private String hr;
    private String rbi;
    private String sb;
    private String cs;
    private String bb;
    private String so;
    private String ba;
    private String obp;
    private String slg;
    private String ops;
    private String opsPlus;
    private String tb;
    private String gdp;
    private String hbp;
    private String sh;
    private String sf;
    private String ibb;
    private String team;

    public Batter(String position, String name, String age, String url, String g, String pa, String ab, String r, String h, String doubles, String triples, String hr, String rbi, String sb, String cs, String bb, String so, String ba, String obp, String slg, String ops, String opsPlus, String tb, String gdp, String hbp, String sh, String sf, String ibb, String team) {
        this.position = position;
        this.name = name;
        this.age = age;
        this.url = url;
        this.g = g;
        this.pa = pa;
        this.ab = ab;
        this.r = r;
        this.h = h;
        this.doubles = doubles;
        this.triples = triples;
        this.hr = hr;
        this.rbi = rbi;
        this.sb = sb;
        this.cs = cs;
        this.bb = bb;
        this.so = so;
        this.ba = ba;
        this.obp = obp;
        this.slg = slg;
        this.ops = ops;
        this.opsPlus = opsPlus;
        this.tb = tb;
        this.gdp = gdp;
        this.hbp = hbp;
        this.sh = sh;
        this.sf = sf;
        this.ibb = ibb;
        this.team = team;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getG() {
        return this.g;
    }

    public void setG(String g) {
        this.g = g;
    }
    
    public String getPa() {
        return this.pa;
    }
    
    public void setPa(String pa) {
        this.pa = pa;
    }
    
    public String getAb() {
        return this.ab;
    }
    
    public void setAb(String ab) {
        this.ab = ab;
    }
    
    public String getR() {
        return this.r;
    }
    
    public void setR(String r) {
        this.r = r;
    }
    
    public String getH() {
        return this.h;
    }
    
    public void setH(String h) {
        this.h = h;
    }
    
    public String getDoubles() {
        return this.doubles;
    }
    
    public void setDoubles(String doubles) {
        this.doubles = doubles;
    }
    
    public String getTriples() {
        return this.triples;
    }
    
    public void setTriples(String triples) {
        this.triples = triples;
    }
    
    public String getHr() {
        return this.hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }
    
    public String getRbi() {
        return this.rbi;
    }
    
    public void setRbi(String rbi) {
        this.rbi = rbi;
    }
    
    public String getSb() {
        return this.sb;
    }
    
    public void setSb(String sb) {
        this.sb = sb;
    }
    
    public String getCs() {
        return this.cs;
    }
    
    public void setCs(String cs) {
        this.cs = cs;
    }
    
    public String getBb() {
        return this.bb;
    }
    
    public void setBb(String bb) {
        this.bb = bb;
    }
    
    public String getSo() {
        return this.so;
    }
    
    public void setSo(String so) {
        this.so = so;
    }
    
    public String getBa() {
        return this.ba;
    }
    
    public void setBa(String ba) {
        this.ba = ba;
    }
    
    public String getObp() {
        return this.obp;
    }
    
    public void setObp(String obp) {
        this.obp = obp;
    }
    
    public String getSlg() {
        return this.slg;
    }
    
    public void setSlg(String slg) {
        this.slg = slg;
    }
    
    public String getOps() {
        return this.ops;
    }
    
    public void setOps(String ops) {
        this.ops = ops;
    }
    
    public String getOpsPlus() {
        return this.opsPlus;
    }
    
    public void setOpsPlus(String opsPlus) {
        this.opsPlus = opsPlus;
    }
    
    public String getTb() {
        return this.tb;
    }
    
    public void setTb(String tb) {
        this.tb = tb;
    }
    
    public String getGdp() {
        return this.gdp;
    }
    
    public void setGdp(String gdp) {
        this.gdp = gdp;
    }
    
    public String getHbp() {
        return this.hbp;
    }
    
    public void setHbp(String hbp) {
        this.hbp = hbp;
    }
    
    public String getSh() {
        return this.sh;
    }
    
    public void setSh(String sh) {
        this.sh = sh;
    }
    
    public String getSf() {
        return this.sf;
    }
    
    public void setSf(String sf) {
        this.sf = sf;
    }
    
    public String getIbb() {
        return this.ibb;
    }
    
    public void setIbb(String ibb) {
        this.ibb = ibb;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public String toString() {
        return this.name;
    }
}
