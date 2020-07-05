	.text
	.intel_syntax noprefix
	.file	"Elf.c"
	.globl	Elf_action1             # -- Begin function Elf_action1
	.p2align	4, 0x90
	.type	Elf_action1,@function
Elf_action1:                            # @Elf_action1
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 16]
	mov	edx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], edx
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	call	Shop_puzzled
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Shop_enter
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Shop_consult
	add	esp, 28
	ret
.Lfunc_end0:
	.size	Elf_action1, .Lfunc_end0-Elf_action1
	.cfi_endproc
                                        # -- End function

	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
