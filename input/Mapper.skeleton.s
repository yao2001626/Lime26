align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern print 
extern Reducer_reduce2 
extern Reducer_reduce1 
extern getRand 
; global methods declare
; global Mapper_methods
global Mapper_init 
global Mapper_map 
; global methods declare

Mapper_init:
Mapper_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Mapper_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; next 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; a 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; e 
    MOV  DWORD [EAX + 4096 - 4*4], 0    ; index 
    MOV  DWORD [EAX + 4096 - 32 + 12], 0    ; next
    MOV  DWORD [EAX + 4096 - 32 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 32 - 4]
    MOV  DWORD [EAX + 4096 - 32 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 32]
    MOV  DWORD [EAX + 4096 - 32], ECX       ; Pre EBP
    LEA  ECX,  [Mapper_doactions]
    MOV  DWORD [EAX + 4096 - 32 - 4], ECX   ; Mapper_doactions
    ADD  DWORD EAX, 4096 - 32
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Mapper_init_code

    MOV DWORD ECX, [ESP + 4]
    	MOV DWORD [EAX + 28], ECX
    	 
    ; init code ends here
    RET
Mapper_doactions:
Mapper_doactions_start:
    PUSH DWORD EBP
    ; CALL Mapper_action
    CALL Mapper_doMap
    POP  EBP
    CALL switch_to_sched
    JMP  Mapper_doactions_start
    RET  ; never be here
;define method Mapper_map
Mapper_map:
Mapper_map_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Mapper_map_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Mapper_map_suspend
Mapper_map_checkguard:
    ; method guard starts here
    ;Mapper_map_guard
    ; method guard ends here
Mapper_map_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Mapper_map_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Mapper_map_start
Mapper_map_succeed:
    ; method body starts here
    ;Mapper_map_body
    ; method body ends here
Mapper_map_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
Mapper_map_ret:
    RET ; define action
; Mapper: doMap 
Mapper_doMap:
Mapper_doMap_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ;Mapper_doMap_guard
    ; action guard end
    JMP   Mapper_doMap_checkguard_fail
Mapper_doMap_succeed:
    ; action body start
    ;Mapper_doMap_body
    ; action body end
Mapper_doMap_checkguard_fail:
    RET