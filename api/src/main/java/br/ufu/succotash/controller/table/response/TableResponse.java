package br.ufu.succotash.controller.table.response;

import br.ufu.succotash.domain.enumeration.TableStatus;
import br.ufu.succotash.domain.model.Table;

public record TableResponse(String id, String name, String urlQrCode, TableStatus status){

    public static TableResponse toTableResponse(Table table) {
        return new TableResponse(table.getId(), table.getName(), table.getUrlQrCode(), table.getStatus());
    }
}
