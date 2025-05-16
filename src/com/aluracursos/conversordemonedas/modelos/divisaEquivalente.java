package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.Map;

public record divisaEquivalente(String result, String base_code, Map<String, Double> conversion_rates) {


}
