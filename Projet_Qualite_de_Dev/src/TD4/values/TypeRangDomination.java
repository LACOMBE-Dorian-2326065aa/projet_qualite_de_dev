package TD4.values;

public enum TypeRangDomination {
    // αβγδεζηθικλμνξοπρστυϕχψω
    RANG_1("ω"),
    RANG_2("ψ"),
    RANG_3("χ"),
    RANG_4("ϕ"),
    RANG_5("υ"),
    RANG_6("τ"),
    RANG_7("σ"),
    RANG_8("ρ"),
    RANG_9("π"),
    RANG_10("ο"),
    RANG_11("ξ"),
    RANG_12("ν"),
    RANG_13("μ"),
    RANG_14("λ"),
    RANG_15("κ"),
    RANG_16("ι"),
    RANG_17("θ"),
    RANG_18("η"),
    RANG_19("ζ"),
    RANG_20("ε"),
    RANG_21("δ"),
    RANG_22("γ"),
    RANG_23("β"),
    RANG_24("α");

    private String rangDomination;

    TypeRangDomination(String rangDomination) {
        this.rangDomination = rangDomination;
    }

    public String getRangDomination() {
        return rangDomination;
    }
}
