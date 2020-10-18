package mlbLineupOptimizer.model;

public class Team {
    
    private String name;
    private String url;
    private String league;
    private String division;
    private String wins;
    private String losses;
    private String gamesBehind;
    private String srs;
    private String ageBatters;
    private String g;
    private String pa;
    private String ab;
    private String rBatters;
    private String hBatters;
    private String doubles;
    private String triples;
    private String hrBatters;
    private String rbi;
    private String sb;
    private String cs;
    private String bbBatters;
    private String soBatters;
    private String ba;
    private String obp;
    private String slg;
    private String ops;
    private String opsPlus;
    private String tb;
    private String gdp;
    private String hbpBatters;
    private String sh;
    private String sf;
    private String ibbBatters;

    private String agePitchers;
    private String winLossPct;
    private String era;
    private String cg;
    private String sho;
    private String sv;
    private String ip;
    private String hPitchers;
    private String rPitchers;
    private String er;
    private String hrPitchers;
    private String bbPitchers;
    private String ibbPitchers;
    private String soPitchers;
    private String hbpPitchers;
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

    public Team(String name, String url, String league, String division, String wins, String losses, String gamesBehind, String srs, String ageBatters, String g, String pa, String ab, String rBatters, String hBatters, String doubles, String triples, String hrBatters, String rbi, String sb, String cs, String bbBatters, String soBatters, String ba, String obp, String slg, String ops, String opsPlus, String tb, String gdp, String hbpBatters, String sh, String sf, String ibbBatters, String agePitchers, String winLossPct, String era, String cg, String sho, String sv, String ip, String hPitchers, String rPitchers, String er, String hrPitchers, String bbPitchers, String ibbPitchers, String soPitchers, String hbpPitchers, String bk, String wp, String bf, String eraPlus, String fip, String whip, String hNine, String hrNine, String bbNine, String soNine, String soWins) {
        this.name = name;
        this.url = url;
        this.league = league;
        this.division = division;
        this.wins = wins;
        this.losses = losses;
        this.gamesBehind = gamesBehind.equals("--") ? "0.0" : gamesBehind;
        this.srs = srs;
        this.ageBatters = ageBatters;
        this.g = g;
        this.pa = pa;
        this.ab = ab;
        this.rBatters = rBatters;
        this.hBatters = hBatters;
        this.doubles = doubles;
        this.triples = triples;
        this.hrBatters = hrBatters;
        this.rbi = rbi;
        this.sb = sb;
        this.cs = cs;
        this.bbBatters = bbBatters;
        this.soBatters = soBatters;
        this.ba = ba;
        this.obp = obp;
        this.slg = slg;
        this.ops = ops;
        this.opsPlus = opsPlus;
        this.tb = tb;
        this.gdp = gdp;
        this.hbpBatters = hbpBatters;
        this.sh = sh;
        this.sf = sf;
        this.ibbBatters = ibbBatters;
        this.agePitchers = agePitchers;
        this.winLossPct = winLossPct;
        this.era = era;
        this.g = g;
        this.cg = cg;
        this.sho = sho;
        this.sv = sv;
        this.ip = ip;
        this.hPitchers = hPitchers;
        this.rPitchers = rPitchers;
        this.er = er;
        this.hrPitchers = hrPitchers;
        this.bbPitchers = bbPitchers;
        this.ibbPitchers = ibbPitchers;
        this.soPitchers = soPitchers;
        this.hbpPitchers = hbpPitchers;
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

    public String getLeague() {
        return this.league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDivision() {
        return this.division;
    }

    public void setDivision(String division) {
        this.division = division;
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

    public String getGamesBehind() {
        return this.gamesBehind;
    }

    public void setGamesBehind(String gamesBehind) {
        this.gamesBehind = gamesBehind;
    }

    public String getSrs() {
        return this.srs;
    }

    public void setSrs(String srs) {
        this.srs = srs;
    }
    
    public String getAgeBatters() {
        return this.ageBatters;
    }

    public void setAgeBatters(String ageBatters) {
        this.ageBatters = ageBatters;
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

    public String getRBatters() {
        return this.rBatters;
    }

    public void setR(String rBatters) {
        this.rBatters = rBatters;
    }

    public String getHBatters() {
        return this.hBatters;
    }

    public void setHBatters(String hBatters) {
        this.hBatters = hBatters;
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

    public String getHrBatters() {
        return this.hrBatters;
    }

    public void setHrBatters(String hrBatters) {
        this.hrBatters = hrBatters;
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

    public String getBbBatters() {
        return this.bbBatters;
    }

    public void setBbBatters(String bbBatters) {
        this.bbBatters = bbBatters;
    }

    public String getSoBatters() {
        return this.soBatters;
    }

    public void setSoBatters(String soBatters) {
        this.soBatters = soBatters;
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

    public String getHbpBatters() {
        return this.hbpBatters;
    }

    public void setHbpBatters(String hbpBatters) {
        this.hbpBatters = hbpBatters;
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

    public String getIbbBatters() {
        return this.ibbBatters;
    }

    public void setIbbBatters(String ibbBatters) {
        this.ibbBatters = ibbBatters;
    }

    public String getAgePitchers() {
        return this.agePitchers;
    }

    public void setAgePitchers(String agePitchers) {
        this.agePitchers = agePitchers;
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

    public String getHPitchers() {
        return this.hPitchers;
    }

    public void setHPitchers(String hPitchers) {
        this.hPitchers = hPitchers;
    }

    public String getRPitchers() {
        return this.rPitchers;
    }

    public void setRPitchers(String rPitchers) {
        this.rPitchers = rPitchers;
    }

    public String getEr() {
        return this.er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getHrPitchers() {
        return this.hrPitchers;
    }

    public void setHrPitchers(String hrPitchers) {
        this.hrPitchers = hrPitchers;
    }

    public String getBbPitchers() {
        return this.bbPitchers;
    }

    public void setBbPitchers(String bbPitchers) {
        this.bbPitchers = bbPitchers;
    }

    public String getIbbPitchers() {
        return this.ibbPitchers;
    }

    public void setIbbPitchers(String ibbPitchers) {
        this.ibbPitchers = ibbPitchers;
    }

    public String getSoPitchers() {
        return this.soPitchers;
    }

    public void setSoPitchers(String soPitchers) {
        this.soPitchers = soPitchers;
    }

    public String getHbpPitchers() {
        return this.hbpPitchers;
    }

    public void setHbpPitchers(String hbpPitchers) {
        this.hbpPitchers = hbpPitchers;
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

    public String toString() {
        return this.name;
    }
}
