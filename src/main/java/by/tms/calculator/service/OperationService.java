package by.tms.calculator.service;

import by.tms.calculator.model.Operation;
import by.tms.calculator.storage.JsonFileOperationStorage;
import by.tms.calculator.storage.TxtFileOperationStorage;
import by.tms.calculator.storage.OperationStorage;

import java.util.List;

public class OperationService {

    private final OperationStorage operationStorage = new JsonFileOperationStorage();

    public Operation execute(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationStorage.save(operation);
                return operation;
        }
        throw new IllegalArgumentException("by.tms.calculator.model.Operation type not supported");
    }

    public List<Operation> getAllOperations() {
        return operationStorage.findAll();
    }
}

