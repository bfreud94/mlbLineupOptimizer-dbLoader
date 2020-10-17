package mlbLineupOptimizer.model;

public class Pitcher {

    private String position;
    private String name;
    private String url;
    private String age;
    private String wins;
    private String losses;
    private String winLossPct;
    private String era;
    private String g;
    private String gs;
    private String gf;
    private String cg;
    private String sho;
    private String sv;
    private String ip;
    private String h;
    private String r;
    private String er;
    private String hr;
    private String bb;
    private String ibb;
    private String so;
    private String hbp;
    private String bk;
    private String wp;
    private String bf;
    private String eraPlus;
    private String fip;
    private String whip;
    private String hNine;
    private String hrNine;
    private String bbNine;
    private String soNine;
    private String soWins;
    private String team;

    public Pitcher(String position, String name, String url, String age, String wins, String losses, String winLossPct, String era, String g, String gs, String gf, String cg, String sho, String sv, String ip, String h, String r, String er, String hr, String bb, String ibb, String so, String hbp, String bk, String wp, String bf, String eraPlus, String fip, String whip, String hNine, String hrNine, String bbNine, String soNine, String soWins, String team) {
        this.position = position;
        this.name = name;
        this.url = url;
        this.age = age;
        this.wins = wins;
        this.losses = losses;
        this.winLossPct = winLossPct;
        this.era = era;
        this.g = g;
        this.gs = gs;
        this.gf = gf;
        this.cg = cg;
        this.sho = sho;
        this.sv = sv;
        this.ip = ip;
        this.h = h;
        this.r = r;
        this.er = er;
        this.hr = hr;
        this.bb = bb;
        this.ibb = ibb;
        this.so = so;
        this.hbp = hbp;
        this.bk = bk;
        this.wp = wp;
        this.bf = bf;
        this.eraPlus = eraPlus;
        this.fip = fip;
        this.whip = whip;
        this.hNine = hNine;
        this.hrNine = hrNine;
        this.bbNine = bbNine;
        this.soNine = soNine;
        this.soWins = soWins;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWins() {
        return this.wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return this.losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getWinLossPct() {
        return this.winLossPct;
    }

    public void setWinLossPct(String winLossPct) {
        this.winLossPct = winLossPct;
    }

    public String getEra() {
        return this.era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getG() {
        return this.g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getGs() {
        return this.gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getGf() {
        return this.gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getCg() {
        return this.cg;
    }

    public void setCg(String cg) {
        this.cg = cg;
    }

    public String getSho() {
        return this.sho;
    }

    public void setSho(String sho) {
        this.sho = sho;
    }

    public String getSv() {
        return this.sv;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getH() {
        return this.h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getR() {
        return this.r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getEr() {
        return this.er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getHr() {
        return this.hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getBb() {
        return this.bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getIbb() {
        return this.ibb;
    }

    public void setIbb(String ibb) {
        this.ibb = ibb;
    }

    public String getSo() {
        return this.so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getHbp() {
        return this.hbp;
    }

    public void setHbp(String hbp) {
        this.hbp = hbp;
    }

    public String getBk() {
        return this.bk;
    }

    public void setBk(String bk) {
        this.bk = bk;
    }

    public String getWp() {
        return this.wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public String getBf() {
        return this.bf;
    }

    public void setBf(String bf) {
        this.bf = bf;
    }

    public String getEraPlus() {
        return this.eraPlus;
    }

    public void setEraPlus(String eraPlus) {
        this.eraPlus = eraPlus;
    }

    public String getFip() {
        return this.fip;
    }

    public void setFip(String fip) {
        this.fip = fip;
    }

    public String getWhip() {
        return this.whip;
    }

    public void setWhip(String whip) {
        this.whip = whip;
    }

    public String getHNine() {
        return this.hNine;
    }

    public void setHNine(String hNine) {
        this.hNine = hNine;
    }

    public String getHrNine() {
        return this.hrNine;
    }

    public void setHrNine(String hrNine) {
        this.hrNine = hrNine;
    }

    public String getBbNine() {
        return this.bbNine;
    }

    public void setBbNine(String bbNine) {
        this.bbNine = bbNine;
    }

    public String getSoNine() {
        return this.soNine;
    }

    public void setSoNine(String soNine) {
        this.soNine = soNine;
    }

    public String getSoWins() {
        return this.soWins;
    }

    public void setSoWins(String soWins) {
        this.soWins = soWins;
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
